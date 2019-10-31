package examples.InfoOperations;

import com.groupdocs.cloud.parser.api.InfoApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.Format;
import com.groupdocs.cloud.parser.model.FormatsResult;

import examples.Common;

/**
 * This example demonstrates how to obtain all supported file types.
 */
public class GetSupportedFileTypes {

    public static void main(String[] args) {

        InfoApi apiInstance = new InfoApi(Common.GetConfiguration());

        try {
            FormatsResult response = apiInstance.getSupportedFileFormats();

            for (Format format : response.getFormats()) {
                System.out.println(format.getFileFormat());
            }
        } catch (ApiException e) {
            System.err.println("Exception while calling InfoApi:");
            e.printStackTrace();
        }
    }
}