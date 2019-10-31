package examples.InfoOperations;

import com.groupdocs.cloud.parser.api.InfoApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.ContainerItem;
import com.groupdocs.cloud.parser.model.ContainerOptions;
import com.groupdocs.cloud.parser.model.ContainerResult;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.requests.GetContainerInfoRequest;

import examples.Common;

/**
 * This example demonstrates how to obtain container items information.
 */
public class GetContainerItemsInformation {

	public static void main(String[] args) {

		InfoApi apiInstance = new InfoApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("containers/archive/zip.zip");
			fileInfo.setStorageName(Common.MyStorage);
			ContainerOptions options = new ContainerOptions();
			options.setFileInfo(fileInfo);
			GetContainerInfoRequest request = new GetContainerInfoRequest(options);
			ContainerResult response = apiInstance.getContainerInfo(request);

			for (ContainerItem item : response.getContainerItems()) {
				System.out.println("Name: " + item.getName() + ". FilePath: " + item.getFilePath());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}