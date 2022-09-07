package org.design.bonpellz.utility;

public class MessageBody {

    private static final String messageHead = " <meta charset=\"UTF-8\" />\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
            "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\"/>\n" +
            "    <!-- jQuery Library -->\n" +
            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
            "    <!-- Popper JS -->\n" +
            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
            "    <!-- Latest Compiled JavaScript -->\n" +
            "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n" +
            "    <title>Bonpellz Newsletter</title>";

    private static final String messageBody = "<div class=\"container\" style=\"margin-top: 2px; justify-content: center;\">\n" +
            "      <div>\n" +
            "        <div>\n" +
            "            <div class=\"background-container\">\n" +
            "          <div style=\"font-size: 14px; font-family: 'Verdana', Geneva, Tahoma, sans-serif; padding: 20px;\">\n" +
            "            <p>\n" +
            "              <span style=\"color: teal; font-weight: 700\">Congratulations!!! </span> on taking your first step in the finest journey to achieve true financial freedom." +
            "               You are now part of a global community of parents and young population of the African continent " +
            "               who are with us on a journey to groom a new prosperous African people, economy and continent as a whole while achieving financial freedom seamlessly.\n" +
            "            </p>\n" +
            "            <p>That's worth a great celebration,<img src=\"https://www.pngarts.com/files/3/Flowers-Download-PNG-Image.png\" width=\"9%x\" height=\"5%\"/> your place in line is\n" +
            "            <span style=\"color:teal; font-weight: 700\">[[position]].</span><br />\n" +
            "            <em>Share your referral code with family and friends to qualify for our referral rewards. Your unique referral link is:</em>\n" +
            "            </p>\n" +
            "            <div style=\"padding: 20px 0px;\">\n" +
            "              <span style=\"color: teal; font-weight: 700; padding: 10px 0px;\">\n" +
            "            <p style=\"font-size: 18px; text-align: center;\">https://www.bonpellz.com?referralCode=[[code]]</p>\n" +
            "            </span>\n" +
            "              <p>\n" +
            "               At Bonpellz, we are providing you opportunity to an incredible\n" +
            "               savings and investment spree, fund supermarket, simplified\n" +
            "               access to wealth management and equity syndicate investment for\n" +
            "               kids (and all).\n" +
            "              </p>\n" +
            "              <div>\n" +
            "                  <h3 style=\"color: rgba(0,0,0,0.6); font-weight:700; padding: 20px 0;\">Now that you have signed up for early access:</h3>\n" +
            "                  <div>\n" +
            "                    Here are the benefits of getting early access to this lovely community.\n" +
            "                    <ul>\n" +
            "                        <li style=\"padding: 5px 0;\">Signing up for early access gives you an edge of being among the first people that would know about Bonpellz's beta app release and first to have access to all our amazing rewards and value offerings.</li>\n" +
            "                        <li style=\"padding: 5px 0;\">Inviting your family and friends to join Bonpellz will help grow this lovely community of one big family on a paradigm shift mission to change the narrative of Africa and her descent wherever they are on the planet.</li>\n" +
            "                        <li style=\"padding: 5px 0;\">The most exciting benefits for you is that the more you share to invite and people get onboarded through your referral link, the more your chance of making your friends and family to be among the lucky families or persons that will qualify for our annual travels and tours, At our official launching (not MVP release but Beta) winners will be announced.</li>\n" +
            "                    </ul>\n" +
            "                  </div>\n" +
            "              </div>\n" +
            "            <div>\n" +
            "                <h3 style=\"color: rgba(0,0,0,0.6); font-weight:700; padding: 20px 0; width: 100%;\">You're better off starting any moment from now!</h3></div>\n" +
            "                <div>\n" +
            "                    <p>Invite more people through your referral link to join the Bonpellz Global Community.<br><br>\n" +
            "                    Be a Super fan of Bonpellz when you rank among the top Bonpellzers that has the highest number of onboarded invitee and win a huge cash price of <b>#200,000</b> at our official launch.<br/>\n" +
            "                    <p style=\"margin-top:20px; margin-bottom:20px\">Talk soon</p>\n" +
            "                    <p style=\"margin-top:20px; margin-bottom:20px\"><b>Joseph</b></p>\n" +
            "                    <p style=\"margin-top:20px; margin-bottom:20px\">CEO Bonpellz</p>\n" +
            "                    </p>\n" +
            "                    <div style=\"position: absolute; left: 40%; margin-top: -100px; opacity: 0.2; width: 100%;\">\n" +
            "                        <img src=\"https://bonpellz.netlify.app/img/Bonpellz%20Logo%20(PNG)%201.png\" height=\"50px\" width=\"200px\"/>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "          </div>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "    </div>";

    public static String  welcomeMessage =

            "<!DOCTYPE html> "+"\n"+
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    messageHead+
                    "</head>\n" +
                    "  <body>\n" +
                    messageBody+
                    "  </body>\n" +
                    "</html>";

    public static final String welcomeMessageSubject = "Welcome to the family!!";

}
