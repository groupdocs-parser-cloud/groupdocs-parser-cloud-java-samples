package examples.ParseOperations.ExtractText;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.ExtractTextOptions;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.TextResult;
import com.groupdocs.cloud.parser.model.requests.ExtractTextRequest;

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
			ExtractTextOptions options = new ExtractTextOptions();
			options.setFileInfo(fileInfo);
			ExtractTextRequest request = new ExtractTextRequest(options);
			TextResult response = apiInstance.extractText(request);

			System.out.println("Text: " + response.getText());
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}