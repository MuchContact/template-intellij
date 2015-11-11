package util;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ApiTest extends JerseyTest{

//    @Mock
//    FixedAssetMapper mapper;

    @Override
    protected Application configure() {
        return super.configure();
//        return new ResourceConfig().packages("com.tw.api").register(new AbstractBinder() {
//            @Override
//            protected void configure() {
////                bind(mapper).to(FixedAssetMapper.class);
//            }
//        });
    }

    @Test
    public void should_post_a_new_fixed_asset() throws Exception {
        Form form  = new Form();
        form.param("name", "Bus");
        form.param("produceDay", "2014-10-1");
        form.param("lifeTime", "10");
        form.param("lifeTimeUnit", "year");
        form.param("originalAmount", "80000");
        form.param("originalNetWorth", "80000");
        form.param("operator", "Li Lin");
        form.param("operatDay", "2014-12-1");
        Response response = target("/fixed_assets")
                .request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        assertThat(response.getStatus(), is(201));

//        verify(mapper, times(1)).addFixedAsset(any());
//        verify(mapper, times(1)).addNewNetWorth(any(), any(), any());

    }

    @Test
    public void should_get_400_when_post_a_new_fixed_asset_with_missing_parameters() throws Exception {
        Form form  = new Form();
        Response response = target("/fixed_assets")
                .request().get();
        assertThat(response.getStatus(), is(400));

    }



}
