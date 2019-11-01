package examples.ParseOperations.ExtractImages;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.Image;
import com.groupdocs.cloud.parser.model.ImagesOptions;
import com.groupdocs.cloud.parser.model.ImagesResult;
import com.groupdocs.cloud.parser.model.requests.ImagesRequest;

import examples.Common;

/**
 * This example demonstrates how to extract images from whole document.
 */
public class ExtractImagesFromTheWholeDocument {

	public static void main(String[] args) {

		ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("slides/three-slides.pptx");
			fileInfo.setStorageName(Common.MyStorage);
			ImagesOptions options = new ImagesOptions();
			options.setFileInfo(fileInfo);
			ImagesRequest request = new ImagesRequest(options);
			ImagesResult response = apiInstance.images(request);

			for (Image image : response.getImages()) {
				System.out.println(
						"Image path in storage: " + image.getPath() + ". Download url: " + image.getDownloadUrl());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}