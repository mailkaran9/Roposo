package roposo.app.karan.roposo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DELL on 4/30/2016.
 */
public class ParseJSON {
    public static String[] title;
    public static String[] description;
    public static String[] si;
    public static String[] id;
    public static String[] db;
    public static String[] username;
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";

    public static final String KEY_DB = "db";
    public static final String KEY_ID = "id";
    public static final String KEY_SI = "si";
    public static final String KEY_USERNAME = "username";
    private JSONArray roposo = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONArray jsonArray=null;
        try {
            jsonArray=new JSONArray(json);


            title= new String[jsonArray.length()];
            description = new String[jsonArray.length()];

            si = new String[jsonArray.length()];
            id=new String[jsonArray.length()];
            db=new String[jsonArray.length()];
            username=new String[jsonArray.length()];
            for(int i=2;i<jsonArray.length();i++){
                JSONObject jo = jsonArray.getJSONObject(i);
                title[i-2] = jo.getString(KEY_TITLE);
                description[i-2] = jo.getString(KEY_DESCRIPTION);
                si[i-2]=jo.getString(KEY_SI);
                db[i-2]=jo.getString(KEY_DB);
                //username[i-2]=jo.getString(KEY_USERNAME);
                for(int j=0;j<2;j++)
                {
                    JSONObject jobj=jsonArray.getJSONObject(j);
                    id[j]=jobj.getString(KEY_ID);
                    System.out.println("id-"+id[j]+"db-"+db[i-2]);
                    System.out.println("here-"+id[j].compareTo(db[i - 2]));
                    if((id[j].compareTo(db[i - 2]))==0)
                    {
                        System.out.println("idhar");
                       username[i-2]= jobj.getString(KEY_USERNAME);
                        System.out.println("--"+username[i-2]);
                    }


                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
