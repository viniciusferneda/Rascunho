package donus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Teste2 {

    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String[] split = inputLine.split(":");
                    String hobbies = split[3];
                    hobbies = hobbies.replace("[", "").replace("]", "").replace("}", "");
                    String[] lHobbies = hobbies.split(",");
                    StringBuilder builder = new StringBuilder();
                    for (String hobbie : lHobbies) {
                        if (builder.length() == 0) {
                            builder.append(hobbie.replace("\"", ""));
                        } else {
                            builder.append(", ").append(hobbie.replace("\"", ""));
                        }
                    }
                    System.out.println(builder.toString());
                }
                in.close();

            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }

    private class People {
        private String name;
        private int age;
        private List<String> hobbies;

        public People() {
        }

        public People(String name, int age, List<String> hobbies) {
            this.name = name;
            this.age = age;
            this.hobbies = hobbies;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<String> getHobbies() {
            return hobbies;
        }
    }

}
