package com.example.elitebook.employeeclient.data.network.model.base;

import java.util.List;

public interface BaseAPIListener {
    void onUnauthorizedError(BaseErrorResponse errorResponse);

    void onAuthenticationError(BaseErrorResponse errorResponse);

    void onForbiddenError(BaseErrorResponse errorResponse);

    void onConflictError(BaseErrorResponse errorResponse);

    void onNotFoundError(BaseErrorResponse errorResponse);

    void onCreateBatchSuccess(List<BatchBadRequestResponse> responses);

    void onCreateBatchError(List<BatchBadRequestResponse> responses);

    void onCreateBatchError(BaseErrorResponse errorResponse);
}
