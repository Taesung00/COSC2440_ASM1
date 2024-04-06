package Functions.DAO;

import Components.Entities.Claim;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public interface ClaimProcessManager {
    public void add(Claim Claim) throws IOException;
    public void update(Claim Claim) throws IOException;
    public void delete(String target);

    public Claim getOne(String ID);

    public ArrayList<Claim> getAll();


}
