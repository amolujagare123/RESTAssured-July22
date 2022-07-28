package PayLoad;

public class ChatServer {

    public String createUserPayLoad()
    {
        return "{\n" +
                "  \"username\": \"avinash1236\",\n" +
                "  \"password\": \"1234\",\n" +
                "  \"email\": \"avinash@example.org\",\n" +
                "  \"name\": \"avinash\",\n" +
                "  \"surname\": \"P\",\n" +
                "  \"chat_nickname\": \"avi\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}" ;
    }

    public String createUserPayLoad(String username,String password,String email,String name,String surname,String nickName)
    {
        return "{\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"surname\": \""+surname+"\",\n" +
                "  \"chat_nickname\": \""+nickName+"\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}" ;
    }
}
