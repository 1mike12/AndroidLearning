package database;

/**
 * Created by mike on 12/21/15.
 */
public class Contact {
    //private variables

    Contact(){

    }

    Contact(String name, String email){
        this._name = name;
        this._email = email;
    }

    int _id;
    String _name;
    String _email;
    String _phone;

    public void setID(int id){
        _id = id;
    }

    public void setName (String name){
        _name = name;
    }

    public void setPhoneNumber (String phone){
        _phone = phone;
    }

    public String toStringContact (){
        return "name: " + _name + " email: " + _email + " phone: " + _phone;
    }
}

