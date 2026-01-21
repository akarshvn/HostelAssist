

package com.hostelassist.roominfo.api;

import com.hostelassist.roominfo.roomInfo;
import com.hostelassist.roominfo.RoominfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GatewayController {

    @GetMapping("/room/{roomNo}")
    public roomInfo getRoom(@PathVariable int roomNo) throws Exception {

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        RoominfoService service =
                (RoominfoService) registry.lookup("RoomService");

        return service.getRoomDetails(roomNo);
    }
}

