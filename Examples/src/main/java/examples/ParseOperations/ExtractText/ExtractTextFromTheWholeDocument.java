package examples.ParseOperations.ExtractText;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.TextOptions;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.TextResult;
import com.groupdocs.cloud.parser.model.requests.TextRequest;

import examples.Common;

/**
 * This example demonstrates how to extract text from whole document.
 */
public class ExtractTextFromTheWholeDocument {

	public static void main(String[] args) {

		ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("email/eml/embedded-image-and-attachment.eml");
			fileInfo.setStorageName(Common.MyStorage);
			TextOptions options = new TextOptions();
			options.setFileInfo(fileInfo);
			TextRequest request = new TextRequest(options);
			TextResult response = apiInstance.text(request);

			System.out.println("Text: " + response.getText());
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}