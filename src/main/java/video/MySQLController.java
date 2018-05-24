package video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.*;

@Component
public class MySQLController {
    private MySQLHelper pMySQLHelper;
    private int i = 1;
    public void insert(String videodetail){
        try{
            pMySQLHelper = new MySQLHelper();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String insert = "Insert Into video Values ("+i+",'uncompleted','"+videodetail+"',null,null,'"+df.format(new Date())+"')";
            i++;
            if (pMySQLHelper.executeNonquery(insert))
            {
                System.out.println("插入成功！！");
            }
            pMySQLHelper.close();
        }
        catch( Exception e){
            System.out.println("插入出錯！！");
            e.printStackTrace();
        }
    }

    public void complete (int id){
        try{
            pMySQLHelper = new MySQLHelper();
            String complete = "update video set task_status = 'complete' where task_id ="+id;
            if(pMySQLHelper.executeNonquery(complete))
            {
                System.out.println("更新成功！！");
            }
            pMySQLHelper.close();
        }
        catch(Exception e){
            System.out.println("更新出错！！");
            e.printStackTrace();
        }
    }
    public void updateHeartBeat(int id){
        try{
            pMySQLHelper = new MySQLHelper();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateheartbeat = "update video set heartbeat ='"+df.format(new Date())+"'where task_id ="+id;
            if(pMySQLHelper.executeNonquery(updateheartbeat))
            {
                System.out.println("更新成功！！");
            }
            pMySQLHelper.close();
        }
        catch(Exception e){
            System.out.println("更新出错！！");
            e.printStackTrace();
        }
    }
    public void checkHeartBeat(){
        pMySQLHelper = new MySQLHelper();
        String checkheartbeat = "update video set task_status = 'uncompleted' where TIMESTAMPDIFF(MINUTE,now(),heartbeat)<5";
        pMySQLHelper.executeNonquery(checkheartbeat);
    }
    public String searchUncompleted(int excutorid){
        pMySQLHelper = new MySQLHelper();
        String sql = "Select * from video where task_status='uncompleted' group by task_id limit 1";
        ResultSet pResultSet = null;
        StringBuilder result = new StringBuilder();
        try{
            pResultSet = pMySQLHelper.query(sql);
            while(pResultSet.next()){
                int id = pResultSet.getInt(1);
                String status = pResultSet.getString(2);
                String videodetail = pResultSet.getString(3);
                result.append(" taskid: "+id);
                result.append(" status: "+status);
                result.append(" videodetail: "+videodetail);
                String update = "update video set task_status= 'processing 'where task_id ="+id;
                String insertexcutorid = "update video set excutorid ="+excutorid+"where task_id="+id;
                pMySQLHelper.executeNonquery(update);
            }
            pMySQLHelper.close();
            pResultSet.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result.toString();
    }
}

