package examples.ParseOperations.ParseByTemplate;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.ContainerItemInfo;
import com.groupdocs.cloud.parser.model.FieldData;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.PageTableAreaCell;
import com.groupdocs.cloud.parser.model.ParseOptions;
import com.groupdocs.cloud.parser.model.ParseResult;
import com.groupdocs.cloud.parser.model.Template;
import com.groupdocs.cloud.parser.model.requests.ParseRequest;

import examples.Common;
import examples.TemplateUtils;;

/**
 * This example demonstrates how to parse a document placed inside a container.
 */
public class ParseByTemplateOfADocumentInsideAContainer {

    public static void main(String[] args) {

        ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

        try {
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFilePath("containers/archive/companies.zip");
            fileInfo.setStorageName(Common.MyStorage);

            ContainerItemInfo containerItemInfo = new ContainerItemInfo();
            containerItemInfo.setRelativePath("companies.docx");

            ParseOptions options = new ParseOptions();
            options.setFileInfo(fileInfo);
            options.setContainerItemInfo(containerItemInfo);
            Template template = TemplateUtils.GetTemplate();
            options.setTemplate(template);
            ParseRequest request = new ParseRequest(options);
            ParseResult response = apiInstance.parse(request);

            for (FieldData data : response.getFieldsData()) {
                if (data.getPageArea().getPageTextArea() != null) {
                    System.out.println("Field name: " + data.getName() + ". Text :"
                            + data.getPageArea().getPageTextArea().getText());
                }

                if (data.getPageArea().getPageTableArea() != null) {
                    System.out.println("Table name: " + data.getName());

                    for (PageTableAreaCell cell : data.getPageArea().getPageTableArea().getPageTableAreaCells()) {
                        System.out.println("Table cell. Row " + cell.getRowIndex() + " column " + cell.getColumnIndex()
                                + ". Text: " + cell.getPageArea().getPageTextArea().getText());
                    }
                }
            }
        } catch (ApiException e) {
            System.err.println("Exception while calling ParseApi:");
            e.printStackTrace();
        }
    }
}