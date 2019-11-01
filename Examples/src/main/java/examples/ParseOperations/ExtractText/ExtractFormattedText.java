package examples.ParseOperations.ExtractText;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.TextOptions;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.FormattedTextOptions;
import com.groupdocs.cloud.parser.model.TextResult;
import com.groupdocs.cloud.parser.model.requests.TextRequest;

import examples.Common;

/**
 * This example demonstrates how to extract formatted text from document.
 */
public class ExtractFormattedText {

	public static void main(String[] args) {

		ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("words-processing/docx/formatted-document.docx");
			fileInfo.setStorageName(Common.MyStorage);
			FormattedTextOptions formattedTextOptions = new FormattedTextOptions();
			formattedTextOptions.setMode("Markdown");
			TextOptions options = new TextOptions();
			options.setFileInfo(fileInfo);
			options.setFormattedTextOptions(formattedTextOptions);
			
			TextRequest request = new TextRequest(options);
			TextResult response = apiInstance.text(request);

			System.out.println("Text: " + response.getText());
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}