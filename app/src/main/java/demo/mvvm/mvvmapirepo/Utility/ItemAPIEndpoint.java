package demo.mvvm.mvvmapirepo.Utility;
import java.util.List;

import demo.mvvm.mvvmapirepo.POJOClasses.Item;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ItemAPIEndpoint {

    @POST("/AddItem")
    Call<Item> addItem(@Body Item item);

    @GET("/GetAllItems")
    Call<List<Item>> getAllItems();

    @GET("/GetItems/{Id}")
    Call<Item> getItems(@Path("Id") Integer Id);

    @PUT("UpdateItem/{Id}")
    Call<Item> updateItem(@Path("Id") Integer Id, @Body Item item);

    @DELETE("/DeleteItem/{Id}")
    Call<Item> deleteItem(@Path("Id") Integer Id);
}
