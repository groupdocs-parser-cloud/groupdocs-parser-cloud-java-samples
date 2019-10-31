package examples.ParseOperations.ParseByTemplate;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.FieldData;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.PageTableAreaCell;
import com.groupdocs.cloud.parser.model.ParseOptions;
import com.groupdocs.cloud.parser.model.ParseResult;
import com.groupdocs.cloud.parser.model.requests.ParseDocumentRequest;

import examples.Common;
import examples.TemplateUtils;;

/**
 * This example demonstrates how to parse a document using template from user
 * storage.
 */
public class ParseByTemplateStoredInUserStorage {

    public static void main(String[] args) {
        // For example purposes create template if not exists.
        TemplateUtils.CreateIfNotExist("templates/companies.json");

        ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

        try {
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFilePath("words-processing/docx/companies.docx");
            fileInfo.setStorageName(Common.MyStorage);
            ParseOptions options = new ParseOptions();
            options.setFileInfo(fileInfo);
            options.setTemplatePath("templates/companies.json");
            ParseDocumentRequest request = new ParseDocumentRequest(options);
            ParseResult response = apiInstance.parseDocument(request);

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