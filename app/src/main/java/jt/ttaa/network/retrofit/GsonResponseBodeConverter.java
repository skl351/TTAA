package jt.ttaa.network.retrofit;


import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import jt.ttaa.model.bean.Result;
import jt.ttaa.model.bean.errorException.ErrorResponse;
import okhttp3.ResponseBody;
import retrofit2.Converter;


/**
 * Created by Administrator on 2017/8/25.
 */

public class GsonResponseBodeConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;


    public GsonResponseBodeConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Result httpResult = gson.fromJson(response, Result.class);
        if (httpResult.getRet() == 200) {
            return gson.fromJson(response, type);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(httpResult.getMsg(),httpResult.getRet());
            throw errorResponse;
        }
    }
}
