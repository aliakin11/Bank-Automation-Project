
package bankaprojesi1;


public class AccountUser extends Account {

    public AccountUser(String hesapturu,Object accountid)
            
    {
        super.SetAccountType(hesapturu);
        super.setBalance(0);
        super.setId((int)Account.generateRandom(9));
    }
}