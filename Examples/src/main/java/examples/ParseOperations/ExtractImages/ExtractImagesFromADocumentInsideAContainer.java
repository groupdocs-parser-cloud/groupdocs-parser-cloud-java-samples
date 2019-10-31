package examples.ParseOperations.ExtractImages;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.ContainerItemInfo;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.Image;
import com.groupdocs.cloud.parser.model.ImagePage;
import com.groupdocs.cloud.parser.model.ImagesOptions;
import com.groupdocs.cloud.parser.model.ImagesResult;
import com.groupdocs.cloud.parser.model.requests.ExtractImagesRequest;

import examples.Common;

/**
 * This example demonstrates how to extract images from container item.
 */
public class ExtractImagesFromADocumentInsideAContainer {

	public static void main(String[] args) {

		ParseApi apiInstance = new ParseApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("pdf/PDF with attachements.pdf");
			fileInfo.setPassword("password");
			fileInfo.setStorageName(Common.MyStorage);
			ContainerItemInfo containerItemInfo = new ContainerItemInfo();
			containerItemInfo.setRelativePath("template-document.pdf");

			ImagesOptions options = new ImagesOptions();
			options.setFileInfo(fileInfo);
			options.setContainerItemInfo(containerItemInfo);
			options.setStartPageNumber(2);
			options.setCountPagesToExtract(1);
			ExtractImagesRequest request = new ExtractImagesRequest(options);
			ImagesResult response = apiInstance.extractImages(request);

			for (ImagePage page : response.getPages()) {
				System.out.println("Images from " + page.getPageIndex() + " page.");
				for (Image image : page.getImages()) {
					System.out.println(
							"Image path in storage: " + image.getPath() + ". Download url: " + image.getDownloadUrl());
				}
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling ParseApi:");
			e.printStackTrace();
		}
	}
}