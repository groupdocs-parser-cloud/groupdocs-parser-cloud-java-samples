package examples.ParseOperations.ExtractText;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.ContainerItemInfo;
import com.groupdocs.cloud.parser.model.TextOptions;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.TextResult;
import com.groupdocs.cloud.parser.model.requests.TextRequest;

import examples.Common;

/**
 * This example demonstrates how to extract text from container item.
 */
public class ExtractTextFromADocumentInsideAContainer {

	public static void main(String[] args) {

		ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("pdf/PDF with attachements.pdf");
			fileInfo.setPassword("password");
			fileInfo.setStorageName(Common.MyStorage);
			ContainerItemInfo containerItemInfo = new ContainerItemInfo();
			containerItemInfo.setRelativePath("template-document.pdf");
			TextOptions options = new TextOptions();
			options.setFileInfo(fileInfo);
			options.containerItemInfo(containerItemInfo);
			options.setStartPageNumber(2);
			options.setCountPagesToExtract(1);

			TextRequest request = new TextRequest(options);
			TextResult response = apiInstance.text(request);

			System.out.println("Text: " + response.getPages().get(0).getText());
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}