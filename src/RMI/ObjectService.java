
package RMI;

import java.io.Serializable;
import java.rmi.*;

public interface ObjectService extends Remote {

    public Serializable requestObject(String studentCode, String qAlias) throws RemoteException;

    public void submitObject(String studentCode, String qAlias, Serializable object) throws RemoteException;
}
