package util.api;

import redis.clients.jedis.Jedis;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/t")
public class Api {
    @Inject
    Jedis jedis;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResp(){
        System.out.println("nihao:-----"+jedis.get("name"));
        return Response.status(200).header("key", 123).header("name", "wo")
                .header("key", 38998).build();
    }
}
