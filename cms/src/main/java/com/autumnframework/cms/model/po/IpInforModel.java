package com.autumnframework.cms.model.po;

/**
 * Created by Mr SJL on 2016/12/8.
 *
 * @Author Junlan Shuai
 */
public class IpInforModel
{
    private String ip;          //  ip
    private String area;        //  地区名称，例如：西南、华北
    private String area_id;     //  地区编号，例如：500000、300000
    private String city;        //  城市名称，例如：重庆市
    private String city_id;     //  城市编号，例如：500100
    private String country;     //  国家名称
    private String country_id;  //  国家编号
    private String county;      //  国家名称
    private String county_id;   //  国家编号
    private String isp;         //  网络服务名称
    private String isp_id;      //  网络服务编号
    private String region;      //  区域名称
    private String region_id;   //  区域编号
    private String visit_time;  //  访问时间

    public String getIsp_id()
    {
        return isp_id;
    }

    public void setIsp_id(String isp_id)
    {
        this.isp_id = isp_id;
    }

    public String getIsp()
    {
        return isp;
    }

    public void setIsp(String isp)
    {
        this.isp = isp;
    }

    public String getCounty_id()
    {
        return county_id;
    }

    public void setCounty_id(String county_id)
    {
        this.county_id = county_id;
    }

    public String getRegion_id()
    {
        return region_id;
    }

    public void setRegion_id(String region_id)
    {
        this.region_id = region_id;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(String country_id)
    {
        this.country_id = country_id;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCity_id()
    {
        return city_id;
    }

    public void setCity_id(String city_id)
    {
        this.city_id = city_id;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getArea_id()
    {
        return area_id;
    }

    public void setArea_id(String area_id)
    {
        this.area_id = area_id;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getVisit_time()
    {
        return visit_time;
    }

    public void setVisit_time(String visit_time)
    {
        this.visit_time = visit_time;
    }
}
