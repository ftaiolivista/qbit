/*
 * Copyright (c) 2015. Rick Hightower, Geoff Chandler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * QBit - The Microservice lib for Java : JSON, WebSocket, REST. Be The Web!
 */
package io.advantageous.qbit.meta;


import io.advantageous.boon.core.Lists;
import io.advantageous.boon.core.TypeType;
import io.advantageous.boon.core.reflection.MethodAccess;
import io.advantageous.qbit.annotation.JsonIgnore;

import java.util.Collections;
import java.util.List;


/**
 * Holds meta-data about a single service method.
 */
public class ServiceMethodMeta {


    @JsonIgnore
    private final MethodAccess methodAccess;
    private final String name;
    private final List<RequestMeta> requestEndpoints;
    private final TypeType returnTypeEnum;
    private final List<TypeType> paramTypes;
    private final boolean hasCallback;
    private final boolean returnCollection;
    private final boolean returnMap;
    private final boolean returnArray;
    private final Class<?> returnType;
    private final Class<?> returnTypeComponent;
    private final Class<?> returnTypeComponentKey;
    private final Class<?> returnTypeComponentValue;
    private final boolean hasReturn;
    private final String description;
    private final String summary;
    private final String returnDescription;

    public ServiceMethodMeta(boolean hasReturn,
                             MethodAccess methodAccess,
                             String name,
                             List<RequestMeta> requestEndpoints,
                             TypeType returnTypeEnum,
                             List<TypeType> paramTypes,
                             boolean hasCallback,
                             boolean returnCollection,
                             boolean returnMap,
                             boolean returnArray,
                             Class<?> returnType,
                             Class<?> returnTypeComponent,
                             Class<?> returnTypeComponentKey,
                             Class<?> returnTypeComponentValue,
                             String description,
                             String summary,
                             String returnDescription) {

        this.hasReturn = hasReturn;
        this.methodAccess = methodAccess;
        this.name = name;
        this.requestEndpoints = requestEndpoints;
        this.returnTypeEnum = returnTypeEnum;
        this.paramTypes = paramTypes;
        this.hasCallback = hasCallback;
        this.returnCollection = returnCollection;
        this.returnMap = returnMap;
        this.returnArray = returnArray;
        this.returnType = returnType;
        this.returnTypeComponent = returnTypeComponent;
        this.returnTypeComponentKey = returnTypeComponentKey;
        this.returnTypeComponentValue = returnTypeComponentValue;
        this.description = description;
        this.summary = summary;
        this.returnDescription = returnDescription;
    }

    public ServiceMethodMeta(String name, List<RequestMeta> requestEndpoints, TypeType returnTypeEnum,
                             List<TypeType> paramTypes) {
        this(true, null,name, requestEndpoints,
                returnTypeEnum, paramTypes,
                false, false, false, false, null, null, null, null, null, null, null);

    }


    public ServiceMethodMeta(MethodAccess methodAccess, List<RequestMeta> list) {
        this(true, methodAccess, methodAccess.name(), list,
                TypeType.OBJECT, Collections.emptyList(),
                false, false, false, false, null, null, null, null, null, null, null);
    }

    public ServiceMethodMeta(String name, List<RequestMeta> list) {
        this(true, null, name, list,
                TypeType.OBJECT, Collections.emptyList(),
                false, false, false, false, null, null, null, null, null, null, null);

    }



    public static ServiceMethodMeta serviceMethod(final MethodAccess methodAccess,
                                                  final RequestMeta... requestMetas) {

        return new ServiceMethodMeta(methodAccess, Lists.list(requestMetas));
    }

    public static ServiceMethodMeta method(final MethodAccess methodAccess,
                                           final RequestMeta... requestMetas) {

        return new ServiceMethodMeta(methodAccess, Lists.list(requestMetas));
    }

    public static ServiceMethodMeta method(final String name,
                                           final RequestMeta... requestMetas) {

        return new ServiceMethodMeta(name, Lists.list(requestMetas));
    }

    public List<RequestMeta> getRequestEndpoints() {
        return requestEndpoints;
    }

    @JsonIgnore
    public MethodAccess getMethodAccess() {
        return methodAccess;
    }

    public String getName() {
        return name;
    }

    public TypeType getReturnTypeEnum() {
        return returnTypeEnum;
    }

    public List<TypeType> getParamTypes() {
        return paramTypes;
    }

    public boolean hasCallBack() {
        return hasCallback;
    }

    public boolean isHasCallback() {
        return hasCallback;
    }

    public boolean isReturnCollection() {
        return returnCollection;
    }

    public boolean isReturnMap() {
        return returnMap;
    }

    public boolean isReturnArray() {
        return returnArray;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public Class<?> getReturnTypeComponent() {
        return returnTypeComponent;
    }

    public Class<?> getReturnTypeComponentKey() {
        return returnTypeComponentKey;
    }

    public Class<?> getReturnTypeComponentValue() {
        return returnTypeComponentValue;
    }

    public boolean isHasReturn() {
        return hasReturn;
    }


    public boolean hasReturn() {
        return hasReturn;
    }

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public String getReturnDescription() {
        return returnDescription;
    }
}
