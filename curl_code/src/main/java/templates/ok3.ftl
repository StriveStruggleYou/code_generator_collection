public JsonArray ${methodName}(String ${methodParam}) {
String ${methodName}Url = UrlConstant.buildListRepositoryBranch(${methodParam});
Request request = UrlConstant.create${requestMethod}Request(${methodName}Url);
//需要解析数据信息
try {
Response response = client.newCall(request).execute();
ResponseBody requestBody = response.body();
JsonArray jsonArray = gson.fromJson(requestBody.string(),
JsonArray.class);
return jsonArray;
} catch (Exception e) {
logger.error("listRepositoryBranches error:", e);
return null;
}
}