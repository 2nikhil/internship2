package com.mobileiron;

import com.mobileiron.AssetsDAO;
import com.mobileiron.Assets_info;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path(value="/assets")
public class Assetresources {
    AssetsDAO dao = new AssetsDAO();
    reservationsDAO d = new reservationsDAO();


    @GET 
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> findall() {
       
        return this.dao.find();
    }
    
    @GET @Path("{id}")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> find_update(@PathParam("id") String id){
    	 return this.dao.find_for_update(id);
    }
    
    @GET @Path("/{category}/{value}")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> findbasingonfilters(@PathParam("category") String category,
    		                                     @PathParam("value") String value){
    	System.out.println("assetresource:-"+category+value);
    	 return this.dao.findbasingoncategory(category,value);
    	
    }
    
    @GET @Path("/manufacturers")
    @Produces(value={"application/json", "application/xml"})
    public List<Assets_info> findmanufacturer(){
    	return this.dao.find_manufacturer();
    }

    /*@POST
    @Consumes(value={"application/xml"})
    @Produces(value={"application/xml"})
    public Assets_info assets_create(Assets_info ai) {
        System.out.println("creating assets");
        return this.dao.assets_create(ai);
    } */

    @POST
    public Response adduser(
    		@FormParam("allowedupgradeornot") boolean allowedupgradeornot,
    		@FormParam("assetnumber") String assetnumber,
    		@FormParam("color") String color,
    		@FormParam("comments") String comments,
    		@FormParam("department") String department,
    		// @FormParam("device_purchasedate") ,
    		@FormParam("devicetype") String devicetype,
    		@FormParam("IMEI") String IMEI,
    		@FormParam("isheadquarters") boolean isheadquarters,
    		@FormParam("isrootedorjailbroken") boolean isrootedorjailbroken,
    		@FormParam("manufacturer") String manufacturer,
    		@FormParam("MDT_no") String MDT_no,
    		@FormParam("modelnumber")String modelnumber) {
    	
    	Assets_info ai = new Assets_info();
    	ai.set_allowed_upgrade(allowedupgradeornot);
    	ai.set_asset_number(assetnumber);
    	ai.set_color(color);
    	ai.set_comments(comments);
    	ai.set_department(department);
    	ai.set_department(department);
    	ai.set_device_type(devicetype);
    	ai.set_IMEI(IMEI);
    	ai.set_is_head_quarters_device(isheadquarters);
    	ai.set_is_rooted_or_jail_broken(isrootedorjailbroken);
    	ai.set_manufacturer(manufacturer);
    	ai.set_MDT_no(MDT_no);
    	ai.set_model_number(modelnumber);
    	
    	
    	
    	
    	dao.assets_create(ai);
    	return Response.status(200).entity("<a href=\"C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html\">go home</a>").build();
    	
    	//return Response.seeOther("file:///C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html");
    	//return Response.seeOther("file:///C:/Users/intern/workspace/mi_asset-management/WebContent/mi_front_end.html");
    }
    
    
    
    @POST @Path(value="/update")
    public Assets_info updateassets(
    		@FormParam("allowedupgradeornot") boolean allowedupgradeornot,
    		@FormParam("assetnumber") String assetnumber,
    		@FormParam("color") String color,
    		@FormParam("comments") String comments,
    		@FormParam("department") String department,
    		// @FormParam("device_purchasedate") ,
    		@FormParam("devicetype") String devicetype,
    		@FormParam("IMEI") String IMEI,
    		@FormParam("isheadquarters") boolean isheadquarters,
    		@FormParam("isrootedorjailbroken") boolean isrootedorjailbroken,
    		@FormParam("manufacturer") String manufacturer,
    		@FormParam("MDT_no") String MDT_no,
    		@FormParam("modelnumber")String modelnumber) {
    	Assets_info ai = new Assets_info();
    	ai.set_allowed_upgrade(allowedupgradeornot);
    	ai.set_asset_number(assetnumber);
    	ai.set_color(color);
    	ai.set_comments(comments);
    	ai.set_department(department);
    	ai.set_department(department);
    	ai.set_device_type(devicetype);
    	ai.set_IMEI(IMEI);
    	ai.set_is_head_quarters_device(isheadquarters);
    	ai.set_is_rooted_or_jail_broken(isrootedorjailbroken);
    	ai.set_manufacturer(manufacturer);
    	ai.set_MDT_no(MDT_no);
    	ai.set_model_number(modelnumber);
    	
    	
    	return this.dao.assets_update(ai);
    }
    
    
    /*@PUT
    @Path(value="/assets/{id}")
    @Consumes(value={"application/json", "application/xml"})
    @Produces(value={"application/json", "application/xml"})
    public Assets_info assets_update(Assets_info ai) {
        System.out.println("updating asset ");
        return this.dao.assets_update(ai);
    } */
/*
    @DELETE
    @Path(value="{id}")
    @Produces(value={"application/json", "application/xml"})
    public void remove_assets(@PathParam(value="id") int mobile_ID) {
        System.out.println("deleting the specified");
        this.dao.assets_delete(mobile_ID);
    }  */
    
    @POST @Path("/register")
    public Assets_info register_asset(@FormParam("user_id") String user_id,
    								  @FormParam("asset_number") String asset_number,
    								  @FormParam("startdate") Date start_time,
    								  @FormParam("enddate") Date end_time){
    	d.user_register();
    	return this.d.register(user_id,asset_number,start_time,end_time);
    }
    
    @DELETE
    @Path(value="{id}")
    @Produces(value={"application/json", "application/xml"})
    public void remove_assets(@PathParam(value="id") String assetnumber) {
        System.out.println("deleting the specified");
        this.dao.assets_delete(assetnumber);
    }
    
    
}