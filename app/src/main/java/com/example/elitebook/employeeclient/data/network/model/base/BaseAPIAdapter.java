package com.example.elitebook.employeeclient.data.network.model.base;

import java.util.List;

public abstract class BaseAPIAdapter implements BaseAPIListener {
    @Override
    public void onUnauthorizedError(BaseErrorResponse errorResponse) {

    }

    @Override
    public void onAuthenticationError(BaseErrorResponse errorResponse) {

    }

    @Override
    public void onForbiddenError(BaseErrorResponse errorResponse) {

    }

    @Override
    public void onConflictError(BaseErrorResponse errorResponse) {

    }

    @Override
    public void onNotFoundError(BaseErrorResponse errorResponse) {

    }

    @Override
    public void onCreateBatchSuccess(List<BatchBadRequestResponse> responses) {

    }

    @Override
    public void onCreateBatchError(List<BatchBadRequestResponse> responses) {

    }

    @Override
    public void onCreateBatchError(BaseErrorResponse errorResponse) {

    }
}
