/*
 * Copyright (c) 2016 EMC Corporation. All Rights Reserved.
 */
package com.emc.ia.sdk.sip.client.rest;

import java.io.InputStream;

import com.emc.ia.sdk.support.http.Response;
import com.emc.ia.sdk.support.http.ResponseBodyFactory;


public class QueryResultFactory extends ResponseBodyFactory<DefaultQueryResult> {

  @Override
  protected DefaultQueryResult doCreate(Response response, InputStream resultStream, Runnable closeResult) {
    boolean cacheOutAipIgnored = response.getHeaderValue("cacheOutAipIgnored", false);
    int aipQuota = response.getHeaderValue("aipQuota", 0);
    int resultSetCount = response.getHeaderValue("resultSetCount", 0);
    int aiuQuota = response.getHeaderValue("aiuQuota", 0);
    int resultSetQuota = response.getHeaderValue("resultSetQuota", 0);
    return new DefaultQueryResult(resultSetQuota, aiuQuota, resultSetCount, aipQuota, cacheOutAipIgnored, resultStream,
        response);
  }

}
