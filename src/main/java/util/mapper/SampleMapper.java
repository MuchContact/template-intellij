package util.mapper;

import org.apache.ibatis.annotations.Param;

import javax.ws.rs.core.MultivaluedMap;

public interface SampleMapper {
    int useFormParamsWithoutList(@Param("form") MultivaluedMap<String, String> form, @Param("pk") PrimaryKey primaryKey);
}
