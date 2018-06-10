JsonObject  ${methodName}() {
String ${methodName}Url = ${requestUrl};
String ${methodName}Content = ${formData};
MediaType mediaType = MediaType.parse(${requestContentType});
RequestBody putBody = RequestBody.create(mediaType, ${methodName}Content);
Request request = UrlConstant.createPutBodyRequest(listProjectBranchesUrl, putBody);
try {
Response response = client.newCall(request).execute();
ResponseBody requestBody = response.body();
JsonObject jsonObject = gson.fromJson(requestBody.string(),
JsonObject.class);
return jsonObject;
} catch (Exception e) {
logger.error("acceptMergeRequest error:", e);
return null;
}
}
