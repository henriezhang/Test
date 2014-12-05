package com.webdev.test;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by henriezhang on 2014/8/8.
 */
public class CharsetTest {
    private static Connection getToolCon() {
        Connection con = null;
        try {
            // 从mysql读取push视频的属性
            Class.forName("com.mysql.jdbc.Driver");
            // ?useUnicode=true&characterEncoding=UTF-8
            String url = "jdbc:mysql://10.198.30.118:3437/web_boss_tool?useUnicode=false&characterEncoding=UTF-8"; //获取协议、IP、端口等信息
            String user = "web_boss_tool"; //获取数据库用户名
            String password = "3b989bb6e";//获取数据库用户密码
            con = DriverManager.getConnection(url, user, password); //创建Connection对象
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return con;
    }

    // 获取专辑属性串
    private static String getCoverRaw(String id) {
        String res = "";
        try {
            Connection con = getToolCon();
            Statement stmt = con.createStatement();
            // 设置编码
            //String enCode = "set names utf8";
            //boolean ret = stmt.execute(enCode);
            //System.out.println("set names ret="+ret);

            // 读取数据
            String table = "t_tubd_video_cid_info";
            String cond = "cid='"+id+"'";
            if(id.length()==11) {
                table = "t_tubd_video_vid_info";
                cond = "vid='"+id+"'";
            }
            String sql = "select title,type_name,subtype_name,area_name,director," +
                    "leading_actor,main_aspect,plot_brief,visual_brief,viewing_experience," +
                    "awards,user_reviews,famous_actor,guests,variety_tags," +
                    "aspect_tag,big_events,cartoon_aspect,production_company,cartoon_director," +
                    "original_author,brief,description " +
                    "from " + table + " where " + cond;
            StringBuilder sb = new StringBuilder();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Col count:"+rs.getMetaData().getColumnCount());
            if(rs.next()) {
                for(int i=1; i<=rs.getMetaData().getColumnCount(); i++) {
                    /*byte[] bCol = rs.getBytes(i);
                    if(bCol.length>0) {
                        System.out.println(new String(bCol, "utf-8"));
                    }*/

                    //System.out.println(new String(tmp.getBytes("latin1"), "utf-8"));
                    //sb.append(rs.getString(i).getBytes("utf8"));
                    //sb.append(rs.getBytes(i).toString());
                    //sb.append(",");
                    //System.out.println(new String(rs.getBytes(i), "utf-8"));

                    String tmp = rs.getString(i);
                    System.out.println(tmp);
                    if(tmp.equals(new String(tmp.getBytes(), "UTF-8"))) {
                        System.out.println("UTF-8");
                    }
                    if(tmp.equals(new String(tmp.getBytes(), "GBK"))) {
                        System.out.println("GBK");
                    }
                    if(tmp.equals(new String(tmp.getBytes(), "GB2312"))) {
                        System.out.println("GB2312");
                    }
                    if(tmp.equals(new String(tmp.getBytes(), "ascii"))) {
                        System.out.println("ascii");
                    }
                    if(tmp.equals(new String(tmp.getBytes(), "latin1"))) {
                        System.out.println("latin1");
                    }
                    if(tmp.equals(new String(tmp.getBytes(), "ISO-8859-1"))) {
                        System.out.println("ISO-8859-1");
                    }
                }
            }
            res = sb.toString();
            System.out.println("XX"+res+"YY");
        } catch (Exception e) {
            System.out.println("Begin Exception");
            System.err.println(e.toString());
            System.out.println("End Exception");
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("step:1");
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("中华人民共和国");
        String result = null;
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        System.out.println("step:2");
        System.setProperty("file.encoding", "utf-8");
        encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        try{
            System.out.println("step:3");
            System.out.println("中华人民共和国");
            // 从mysql读取push视频的属性
            System.out.println("AA");
            String rawStr = getCoverRaw("xrdi42fqxso9h3s");
            System.out.println(rawStr);
            System.out.println("BB");
        } catch(Exception e)  {
            System.out.println(e.toString());
        }
    }
}
