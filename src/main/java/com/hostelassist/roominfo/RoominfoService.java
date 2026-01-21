

package com.hostelassist.roominfo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RoominfoService extends Remote {

    roomInfo getRoomDetails(int roomNo) throws RemoteException;

    String getWardenContact(int roomNo) throws RemoteException;
}
