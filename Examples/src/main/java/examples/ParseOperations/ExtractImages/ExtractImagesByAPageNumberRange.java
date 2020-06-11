package examples.ParseOperations.ExtractImages;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.Image;
import com.groupdocs.cloud.parser.model.ImagePage;
import com.groupdocs.cloud.parser.model.ImagesOptions;
import com.groupdocs.cloud.parser.model.ImagesResult;
import com.groupdocs.cloud.parser.model.requests.ImagesRequest;

import examples.Common;

/**
 * This example demonstrates how to extract images from pages range.
 */
public class ExtractImagesByAPageNumberRange {

	public static void main(String[] args) {

		ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("slides/three-slides.pptx");
			fileInfo.setStorageName(Common.MyStorage);

			ImagesOptions options = new ImagesOptions();
			options.setFileInfo(fileInfo);
			options.setStartPageNumber(1);
			options.setCountPagesToExtract(2);
			ImagesRequest request = new ImagesRequest(options);
			ImagesResult response = apiInstance.images(request);

			for (ImagePage page : response.getPages()) {
				System.out.println("Images from " + page.getPageIndex() + " page.");
				for (Image image : page.getImages()) {
					System.out.println(
							"Image path in storage: " + image.getPath() + ". Download url: " + image.getDownloadUrl());
					System.out.println("Image format: " + image.getFileFormat());
				}
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}