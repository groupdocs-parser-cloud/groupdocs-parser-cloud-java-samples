package examples.ParseOperations.ExtractText;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.ExtractTextOptions;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.TextPage;
import com.groupdocs.cloud.parser.model.TextResult;
import com.groupdocs.cloud.parser.model.requests.ExtractTextRequest;

import examples.Common;

/**
 * This example demonstrates how to extract text from pages range.
 */
public class ExtractTextByAPageNumberRange {

	public static void main(String[] args) {

		ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("cells/two-worksheets.xlsx");
			fileInfo.setStorageName(Common.MyStorage);
			ExtractTextOptions options = new ExtractTextOptions();
			options.setFileInfo(fileInfo);
			options.setStartPageNumber(1);
			options.setCountPagesToExtract(1);
			ExtractTextRequest request = new ExtractTextRequest(options);
			TextResult response = apiInstance.extractText(request);
			for (TextPage page : response.getPages()) {
				System.out.println("PageIndex: " + page.getPageIndex() + ". Text: " + page.getText());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}