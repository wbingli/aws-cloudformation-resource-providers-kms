package software.amazon.kms.alias;

import software.amazon.awssdk.services.kms.model.AliasListEntry;
import software.amazon.awssdk.services.kms.model.CreateAliasRequest;
import software.amazon.awssdk.services.kms.model.DeleteAliasRequest;
import software.amazon.awssdk.services.kms.model.ListAliasesRequest;
import software.amazon.awssdk.services.kms.model.UpdateAliasRequest;


public class Translator {
    static CreateAliasRequest createAliasRequest(final ResourceModel resourceModel) {
        return CreateAliasRequest.builder()
                .aliasName(resourceModel.getAliasName())
                .targetKeyId(resourceModel.getTargetKeyId())
                .build();
    }

    static DeleteAliasRequest deleteAliasRequest(final String aliasName) {
        return DeleteAliasRequest.builder()
                .aliasName(aliasName)
                .build();
    }

    static ListAliasesRequest listAliasesRequest(final String keyId,
                                                 final String nextToken) {
        return ListAliasesRequest.builder()
                .keyId(keyId)
                .marker(nextToken).build();
    }

    static ResourceModel translateToResourceModel(final AliasListEntry aliasListEntry) {
        return ResourceModel.builder()
                .aliasName(aliasListEntry.aliasName())
                .targetKeyId(aliasListEntry.targetKeyId()).build();
    }

    static UpdateAliasRequest updateAliasRequest(final ResourceModel resourceModel) {
        return UpdateAliasRequest.builder()
                .aliasName(resourceModel.getAliasName())
                .targetKeyId(resourceModel.getTargetKeyId())
                .build();
    }
}
