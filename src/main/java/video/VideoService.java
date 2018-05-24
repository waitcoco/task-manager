package video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class VideoService {
    @Autowired
    private MySQLController mySQLController;

    @RequestMapping("/insertVideo")
    public void insertVideo(@RequestParam(value="videodetail") String videodetail){
        mySQLController.insert(videodetail);
    }

    @RequestMapping("/getVideo")
    public String getVideo(@RequestParam(value="excutorid") int excutorid){
        return mySQLController.searchUncompleted(excutorid);
    }

    @RequestMapping("/complete")
    public void complete(@RequestParam(value="id") int id){
        mySQLController.complete(id);
    }
    @RequestMapping("/updateheartbeat")
    public void updateheartbeat(@RequestParam(value="id") int id){
        mySQLController.updateHeartBeat(id);
    }
}
