import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author Eignara
 */
public class spades extends javax.swing.JFrame {

    /**
     * Creates new form spades
     */
    public spades() {
        initComponents();
        gamePanel.setVisible(false);
        instructionsPanel.setVisible(false);
        lobbyPanel.setVisible(false);
        playerOptionsPanel.setVisible(false);
        loginPanel.setVisible(false);
        placingPanel.setVisible(false);
        finalPanel.setVisible(false);
        dialogPanel.setVisible(false);
        spadesIntro.setVisible(true);
        youBidLabel.setText("");
        bidPick();
        randomCard();
        gabbysCards();
        mannysCards();
        barbsCards();
        gabbyCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/sb13.png")));
        barbaraCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/ub13.png")));
        mannyCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/sb13.png")));
    }
    public int yourbid = 0, yes = 1, delay = 2000, lo = 0, delay2 = 500, go = 0, z = 0, mannyBid, gabbyBid, barbBid, spades = 0, started = 0, turn = 0, roundCheck = 0, submitted = 0, p1, p2, p3, p4, startingturn, firstspades = 0;
    public String playername, type;
    public String[] myCards = new String[13];
    public String[] gaCards = new String[13];
    public String[] maCards = new String[13];
    public String[] baCards = new String[13];
    public String[] hand = new String[13];
    String[] playedCards = new String[4];
    public int[] points = {0, 0, 0, 0};
    public String[] deckCards = {"h0", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11", "h12","i0", "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10", "i11", "i12","j0", "j1", "j2", "j3", "j4", "j5", "j6", "j7", "j8", "j9", "j10", "j11", "j12","k0", "k1", "k2", "k3", "k4", "k5", "k6", "k7", "k8", "k9", "k10", "k11", "k12"};
    Random random = new Random();
    

    Timer timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    switch (go) {
                        case 0:
                            lobbyPanel.setVisible(true);
                            go++;
                            break;
                        case 1:
                            numPlayers.setText("Number of users waiting to play: 4");
                            delay = 3000;
                            go++;
                            break;
                        case 2:
                            placingPanel.setVisible(true);
                            delay = 5000;
                            go++;
                            break;
                        case 3:
                            lobbyPanel.setVisible(false);
                            instructionsPanel.setVisible(true);
                            delay = 1500;
                            go++;
                            break;
                            
                        case 4:
                            timer.stop();
                            break;
                    }
                    
                     repaint();                  
                }
            });
    
    Timer timer5 = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(z == 0){
                yes = 1;
                
                dialogPanel.setVisible(false);
                z++;
            }
            
            if(z == 1){
                
                z = 0;
                timer5.stop();
                
            }
            
                            
        }
    });
    
    Timer timer6 = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        
                        finalPanel.setVisible(true);
                        gamePanel.setVisible(false);
                        timer6.stop();
                            
                    }
                });
    
    Timer timer7 = new Timer(3000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(lo == 0){
                p1 = 0;
                p2 = 0;
                p3 = 0;
                p4 = 0;
                gabbyCard.setIcon(null);
                yourCard.setIcon(null);
                mannyCard.setIcon(null);
                barbaraCard.setIcon(null);
                lo++;
            }
                        
            if(lo == 1){
               lo = 0;
               timer7.stop();
               if(roundCheck >= 4){
                   
               }
               
               else{
                    round();
               }
               
               
            }
                        
        }
    });
    
    private void randomCard(){
        String test;
        int i = 0;
        char ch = 'h';

        while(i < 13){
            test = (String) (Character.toString((char) (ch + random.nextInt(4) + 0))) + (random.nextInt(13) + 0);
            for(int j = 0; j < 52; j++){
                if(deckCards[j].equals(test)){
                    deckCards[j] = "0";
                    j = 53;
                    myCards[i] = test;
                    i++;
                }
                
            }
        }
        
        
        for(int x = 0; x < 13; x++){
            switch (x) {
                case 0:
                    a1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 1:
                    a3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 2:
                    a4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 3:
                    a5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 4:
                    a6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 5:
                    a7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 6:
                    a8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 7:
                    a9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 8:
                    a10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 9:
                    a11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 10:
                    a12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 11:
                    a13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
                case 12:
                    a2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(myCards[x]))));
                    break;
            }
            
            
        }
        
        
    
    }
    
    private String cardImages(String card){
        String imageLink = "";
        if(card.equals("h0")){
            imageLink = "Images/h0.png";
        }
        
        if(card.equals("h1")){
            imageLink = "Images/h1.png";
        }
        
        if(card.equals("h2")){
            imageLink = "Images/h2.png";
        }
        
        if(card.equals("h3")){
            imageLink = "Images/h3.png";
        }
        
        if(card.equals("h4")){
            imageLink = "Images/h4.png";
        }
        
        if(card.equals("h5")){
            imageLink = "Images/h5.png";
        }
        
        if(card.equals("h6")){
            imageLink = "Images/h6.png";
        }
        
        if(card.equals("h7")){
            imageLink = "Images/h7.png";
        }
        
        if(card.equals("h8")){
            imageLink = "Images/h8.png";
        }
        
        if(card.equals("h9")){
            imageLink = "Images/h9.png";
        }
        
        if(card.equals("h10")){
            imageLink = "Images/h10.png";
        }
        
        if(card.equals("h11")){
            imageLink = "Images/h11.png";
        }
        
        if(card.equals("h12")){
            imageLink = "Images/h12.png";
        }
        
        if(card.equals("i12")){
            imageLink = "Images/i12.png";
        }
        
        if(card.equals("i0")){
            imageLink = "Images/i0.png";
        }
        
        if(card.equals("i1")){
            imageLink = "Images/i1.png";
        }
        
        if(card.equals("i2")){
            imageLink = "Images/i2.png";
        }
        
        if(card.equals("i3")){
            imageLink = "Images/i3.png";
        }
        
        if(card.equals("i4")){
            imageLink = "Images/i4.png";
        }
        
        if(card.equals("i5")){
            imageLink = "Images/i5.png";
        }
        
        if(card.equals("i6")){
            imageLink = "Images/i6.png";
        }
        
        if(card.equals("i7")){
            imageLink = "Images/i7.png";
        }
        
        if(card.equals("i8")){
            imageLink = "Images/i8.png";
        }
        
        if(card.equals("i9")){
            imageLink = "Images/i9.png";
        }
        
        if(card.equals("i10")){
            imageLink = "Images/i10.png";
        }
        
        if(card.equals("i11")){
            imageLink = "Images/i11.png";
        }
        
        if(card.equals("j0")){
            imageLink = "Images/j0.png";
        }
        
        if(card.equals("j1")){
            imageLink = "Images/j1.png";
        }
        
        if(card.equals("j2")){
            imageLink = "Images/j2.png";
        }
        
        if(card.equals("j3")){
            imageLink = "Images/j3.png";
        }
        
        if(card.equals("j4")){
            imageLink = "Images/j4.png";
        }
        
        if(card.equals("j5")){
            imageLink = "Images/j5.png";
        }
        
        if(card.equals("j6")){
            imageLink = "Images/j6.png";
        }
        
        if(card.equals("j7")){
            imageLink = "Images/j7.png";
        }
        
        if(card.equals("j8")){
            imageLink = "Images/j8.png";
        }
        
        if(card.equals("j9")){
            imageLink = "Images/j9.png";
        }
        
        if(card.equals("j10")){
            imageLink = "Images/j10.png";
        }
        
        if(card.equals("j11")){
            imageLink = "Images/j11.png";
        }
        
        if(card.equals("j12")){
            imageLink = "Images/j12.png";
        }
        
        if(card.equals("k0")){
            imageLink = "Images/k0.png";
        }
        
        if(card.equals("k1")){
            imageLink = "Images/k1.png";
        }
        
        if(card.equals("k2")){
            imageLink = "Images/k2.png";
        }
        
        if(card.equals("k3")){
            imageLink = "Images/k3.png";
        }
        
        if(card.equals("k4")){
            imageLink = "Images/k4.png";
        }
        
        if(card.equals("k5")){
            imageLink = "Images/k5.png";
        }
        
        if(card.equals("k6")){
            imageLink = "Images/k6.png";
        }
        
        if(card.equals("k7")){
            imageLink = "Images/k7.png";
        }
        
        if(card.equals("k8")){
            imageLink = "Images/k8.png";
        }
        
        if(card.equals("k9")){
            imageLink = "Images/k9.png";
        }
        
        if(card.equals("k10")){
            imageLink = "Images/k10.png";
        }
        
        if(card.equals("k11")){
            imageLink = "Images/k11.png";
        }
        
        if(card.equals("k12")){
            imageLink = "Images/k12.png";
        }
        
        
    
        return imageLink;
    }
    
    
    private void setIcon(String card){
        switch (turn) {
            case 0:
                yourCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(card))));
                break;
            case 1:
                mannyCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(card))));
                break;
            case 2:
                barbaraCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(card))));
                break;
            case 3:
                gabbyCard.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImages(card))));
                break;
        }
    }
    
    
    private void gabbysCards(){
        String test;
        int i = 0;
        char ch = 'k';

        while(i < 13){
            test = (String) (Character.toString((char) (ch - random.nextInt(3) + 0))) + (random.nextInt(12) + 0);
            for(int j = 0; j < 52; j++){
                if(deckCards[j].equals(test)){
                    deckCards[j] = "0";
                    j = 53;
                    gaCards[i] = test;
                    i++;
                }
                
            }
        }
        
        
    }
    
    private void mannysCards(){
        String test;
        int i = 0;
        char ch = 'h';

        while(i < 13){
            test = (String) (Character.toString((char) (ch + random.nextInt(3) + 0))) + (random.nextInt(12) + 0);
            for(int j = 0; j < 52; j++){
                if(deckCards[j].equals(test)){
                    deckCards[j] = "0";
                    j = 53;
                    maCards[i] = test;
                    i++;
                }
                
            }
        }
        
       
    }
    
    private void barbsCards(){
        int i = 0, j =0;
        while(i < 52){
            if(deckCards[i].equals("0")){
                i++;
            }
            
            else{
                baCards[j] = deckCards[i];
                i++;
                j++;
            }
        }
        
       
    }
    
    public String getLetter(String splitting){
        String[] splice = splitting.split("(?<=\\D)(?=\\d)");
        return splice[0];
    }
    
    public int getNumber(String splitting){
        int hold;
        String[] splice = splitting.split("(?<=\\D)(?=\\d)");
        hold = Integer.parseInt(splice[1]);
        return hold;
    }
    
    private void checkCard(String card, int player){
            playedCards[player] = card;
            setIcon(card);
        
    }
    
    private int check(String card, int player){
        
        
        
        if(started == 0){
            if(firstspades == 0){
                
                if("k".equals(getLetter(card))){
                    if(handCheck(player) == 1){
                        firstspades = 1;
                        spades = 1;
                        return 1;
                    }
                    
                    else{
                        return 0;
                    }
                    
                }
            }
            
            type = getLetter(card);
                
            started = 1;
            return 1;
        }
        
        if("k".equals(getLetter(card))){
            
            if("k".equals(type)){
                firstspades = 1;
                spades = 1;
                return 1;
            
            }
            
            else if(spades == 1){
                firstspades = 1;
                spades = 1;
                return 1;
            }
            
            else if(!("k".equals(type))){
                if(handCheck(player) == 1){
                    firstspades = 1;
                    spades = 1;
                    return 1;
                }
                
                else{
                    return 0;
                }
            }
            
            else{
                if(handCheck(player) == 1){
                    firstspades = 1;
                    spades = 1;
                    return 1;
                }
                    
                else{
                    return 0;
                }
            }
            
                    
        }
        
        else if("null".equals(card)){
            return 0;
        }
        
        else if(spades == 0){
                if(type.equals(getLetter(card))){
                    return 1;
                }
            
                else{
                    if(handCheck(player) == 1){
                        if(getLetter(card).equals("k")){
                            firstspades = 1;
                            spades = 1;
                        }
                        
                        return 1;
                    }
                    return 0;
                }
            
        }
        
        else{
            if(type.equals(getLetter(card))){
                return 1;
            }
            
            else{
                if(getLetter(card).equals("k")){
                    firstspades = 1;
                    spades = 1;
                    return 1;
                }
                
                else if(handCheck(player) == 1){
                    return 1;
                }
                
                else{
                    return 0;
                }
            }
        }
        
        
    }
    
    private int handCheck(int g){
        int l;
        switch (g) {
            case 0:
                for(l = 0; l < 13; l++){
                    hand[l] = myCards[l];
                    
                }   
                
                break;
            case 1:
                for(l = 0; l < 13; l++){
                    hand[l] = maCards[l];
               
                }   
               
                break;
            case 2:
                for(l = 0; l < 13; l++){
                    hand[l] = baCards[l];
              
                }   
            
                break;
            case 3:
                for(l = 0; l < 13; l++){
                    hand[l] = gaCards[l];
               
                }   
                
                break;
            
        }
        
        for(int y = 0; y < 13; y++){
            
            if(getLetter(hand[y]).equals(type)){
                return 0;
            }
            
        }
        
        return 1;
    }
    
    private void playerOne(int f, int q){
        if("null".equals(myCards[f])){
            //JOptionPane.showMessageDialog(null, "This card has already been played. Please choose another card.");
            dialogText.setText("This card has already been played. Please choose another card.");
            dialogPanel.setVisible(true);
            yes = 1;
            timer5.setRepeats(true);
            timer5.start();
        }
        
        else if((firstspades == 0) && ("k".equals(getLetter(myCards[f])))){
            //JOptionPane.showMessageDialog(null, "You cannot lead with spades.");
            dialogText.setText("You cannot lead with spades.");
            dialogPanel.setVisible(true);
            yes = 1;
            timer5.setRepeats(true);
            timer5.start();
        }
        
        else if(check(myCards[f], q) == 0){
            //JOptionPane.showMessageDialog(null, "You must play the card that matches the suit.");
            dialogText.setText("You must play the card that matches the suit.");
            dialogPanel.setVisible(true);
            yes = 1;
            timer5.setRepeats(true);
            timer5.start();
        }
        
        else{
            checkCard(myCards[f], q);
            submitted = 1;
            p1 = 1;
            myCards[f] = "null";
            turn++;
        }
    }
    
    
    private void bidPick(){
        mannyBid = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        barbBid = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        gabbyBid = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        
        gabbyBidLabel.setText("Gabbylicious bids " + gabbyBid);
        mannyBidLabel.setText("mAne11o bids " + mannyBid);
        barbBidLabel.setText("justiceforbarb2017 bids " + barbBid);
    }
    
    public void round(){
        
        int t = 0;
        System.out.println(" ");
        
        int largest, kcount;
        
        
        if((p1 == 1) && (p2 == 1) && (p3 == 1) && (p4 == 1)){
            largest = startingturn;
            
            kcount = 0;
          
            submitted = 0;
            spades = 0;
            started = 0;
            
            
            
                for(int d = 0; d < 4; d++){
                    
                    if(!(type.equals(getLetter(playedCards[d])))){
                        if(getLetter(playedCards[d]).equals("k")){
                            kcount++;
                            
                            if(kcount > 1){
                                if(getNumber(playedCards[d]) == 0){
                                    largest = d;
                                
                                }
                                
                                else if(getNumber(playedCards[largest]) == 0){
                                    
                                }
                                
                                else if(getNumber(playedCards[d]) > getNumber(playedCards[largest])){
                                    largest = d;
                                }
                            }
                            
                            else{
                                largest = d;
                               
                            }
                            
                        }
                        
                       
                    }
                    
                    else{
                        if("k".equals(getLetter(playedCards[largest]))){
                            if("k".equals(type)){
                                kcount++;
                            
                                if(kcount > 1){
                                    if(getNumber(playedCards[d]) == 0){
                                        largest = d;
                                
                                    }
                                
                                    else if(getNumber(playedCards[largest]) == 0){
                                    
                                    }
                                
                                    else if(getNumber(playedCards[d]) > getNumber(playedCards[largest])){
                                        largest = d;
                                    }
                                }
                            
                                else{
                                    largest = d;
                                    
                                }
                                
                                
                            
                            }
                            
                            else{
                                //DO NOT CHANGE A THING
                            }
                            
                            
                                
                        }
                            
                        else{
                            if(getNumber(playedCards[d]) == 0){
                                largest = d;
                            }
                        
                            else if(getNumber(playedCards[largest]) == 0){
                            
                            }
                        
                            else if(getNumber(playedCards[d]) > getNumber(playedCards[largest])){
                                largest = d;
                            }
                    }
                }
            }
                
                
            if(roundCheck == 4){
               
                    points[largest] = points[largest] + 1;
                
                
                whoWonRound(largest);
                scoring();
                    
                timer6.setRepeats(false);
                timer6.start();
                
                
            }
            
            else{
                roundCheck++;
                turn = largest;
                startingturn = turn;
                
                    points[largest] = points[largest] + 1;
                
                
                
                for(int ty = 0; ty < 4; ty++){
                    System.out.println(ty + " has " + points[ty] + " points.");
                }
                whoWonRound(largest);
                timer7.setRepeats(true);
                timer7.start();
                
            }
                
            
        }
         
            
        
        
        else{
           
            switch (turn) {
                case 0:
                    youBidLabel.setForeground(Color.RED);
                    break;
                case 1:
                    mannyBidLabel.setForeground(Color.RED);
                    Timer timer2 = new Timer(2000, new ActionListener() {
                        
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            int o = 0;
                             
                            if(!("null".equals(maCards[o]))){
                                while((check(maCards[o], turn) == 0) && (o < (12 - roundCheck))){
                                    o++;
                                }
                            
                                checkCard(maCards[o], turn);
                                p2 = 1;
                                mannyCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/sb" + (12-roundCheck) + ".png")));
                                
                                repaint();
                                maCards[o] = "null";
                                maCards = sort(turn).clone();
                                turn++;
                                mannyBidLabel.setForeground(Color.BLACK);
                                round();
                            }
                            
                            else{
                                round();
                            }
                            
                            
                        }
                    });     
                    timer2.setRepeats(false);
                    timer2.start();
                    break;
                case 2:
                    barbBidLabel.setForeground(Color.RED);
                    Timer timer3 = new Timer(2000, new ActionListener() {
                        
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int o = 0;
                    
                    if(!("null".equals(baCards[o]))){
                        while((check(baCards[o], turn) == 0) && (o < (12 - roundCheck))){
                            o++;
                        }   
                        checkCard(baCards[o], turn);
                        p3 = 1;
                        barbaraCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/ub" + (12-roundCheck) + ".png")));
                        
                        repaint(); 
                        baCards[o] = "null";
                        baCards = sort(turn).clone();
                        barbBidLabel.setForeground(Color.BLACK);
                        turn++;
                        
                        round();
                    
                    
                   }
                    
                    else{
                        round();
                    }
                    
                    
                                      
                }
            });
                   timer3.setRepeats(false);
                   timer3.start();
                    break;
                case 3:
                   gabbyBidLabel.setForeground(Color.RED); 
                    Timer timer4 = new Timer(2000, new ActionListener() {
                        
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int o = 0;
                    if(!("null".equals(gaCards[o]))){
                        while((check(gaCards[o], turn) == 0) && (o < (12 - roundCheck))){
                            o++;
                        }   
                        checkCard(gaCards[o], turn);
                        p4 = 1;
                        gabbyCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/sb" + (12-roundCheck) + ".png")));
                        
                        repaint();
                        gaCards[o] = "null";
                        gaCards = sort(turn).clone();
                        turn = 0;
                        gabbyBidLabel.setForeground(Color.BLACK);
                        
                        round();
                    }
                    
                    else{
                        round();
                    }
                    
                    
                                       
                }
            });
                    timer4.setRepeats(false);
                    timer4.start();
                    break;
                
            }
                
        }
        
        
    }
    
    private String[] sort(int player){
        int l, u = 0;
        String[] hand2 = new String[13];
        
        
        for(l = 0; l < hand2.length; l++){
            hand2[l] = "0";
                    
        }
        switch (player) {
            case 0:
                   
                break;
            case 1:
                for(l = 0; l < 13; l++){
                    if(!(maCards[l].equals("null"))){
                        hand2[u] = maCards[l];
                        
                        u++;
                        
                    }
                }   
               
                break;
            case 2:
                for(l = 0; l < 13; l++){
                    if(!(baCards[l].equals("null"))){
                        hand2[u] = baCards[l];
                        u++;
                    }
                }   
               
                break;
            case 3:
                for(l = 0; l < 13; l++){
                    if(!(gaCards[l].equals("null"))){
                        hand2[u] = gaCards[l];
                        u++;
                    }
               
                }   
                
                break;
            
        }
        
        
        
        
        return hand2;
    }
    
    private void whoWonRound(int roundwinner){
        switch (roundwinner) {
            case 0:
                //JOptionPane.showMessageDialog(null, "You won this round!");
                dialogText.setText("You won this round!");
                dialogPanel.setVisible(true);
                yes = 0;
                timer5.setRepeats(true);
                timer5.start();
                break;
            case 1:
                //JOptionPane.showMessageDialog(null, "mAne11o wins this round!");
                dialogText.setText("mAne11o wins this round!");
                dialogPanel.setVisible(true);
                yes = 0;
                timer5.setRepeats(true);
                timer5.start();
                break;
            case 2:
                //JOptionPane.showMessageDialog(null, "justiceforbarb2017 wins this round!");
                dialogText.setText("justiceforbarb2017 wins this round!");
                dialogPanel.setVisible(true);
                yes = 0;
                timer5.setRepeats(true);
                timer5.start();
                break;
            case 3:
                //JOptionPane.showMessageDialog(null, "Gabbylicious wins this round!");
                dialogText.setText("Gabbylicious wins this round!");
                dialogPanel.setVisible(true);
                yes = 0;
                timer5.setRepeats(true);
                timer5.start();
                break;
        }
    }
    
    
    
    private void scoring(){
        int team1bids, team2bids, team1score, team2score, team1tricks, team2tricks, youbags, mannybags, barbbags, gabbybags, team1bags, team2bags;
        
        
        
        team1bids = yourbid + barbBid;
        team2bids = mannyBid + gabbyBid;
        
        
        
        team1tricks = points[0] + points[2];
        team2tricks = points[1] + points[3];
        
        youbags = points[0] - yourbid;
        mannybags = points[1] - mannyBid;
        barbbags = points[2] - barbBid;
        gabbybags = points[3] - gabbyBid;
        
        
        team1bags = youbags + barbbags;
        team2bags = mannybags + gabbybags;
        
        if(team1bags < 0){
            team1bags = 0;
        }
        
        if(team2bags < 0){
            team2bags = 0;
        }
        
        if((points[0] > 0) && (yourbid == 0)){
            points[0] = -10;
        }
        
        team1score = pointscheck((points[0]+points[2]), team1bids, team1bags);
        team2score = pointscheck((points[1]+points[3]), team2bids, team2bags);
        
        onetotalbid.setText(playername + " and justiceforbarb2017's total bid: " + team1bids);
        onetotaltricks.setText(playername + " and justiceforbarb2017's tricks taken: " + team1tricks);
        onetotalbags.setText(playername + " and justiceforbarb2017's total bags: " + team1bags);
        onescore.setText(playername + " and justiceforbarb2017's points this round: " + team1score);
        
        twototalbid.setText("mAne11o and Gabbylicious's total bid: " + team2bids);
        twototaltricks.setText("mAne11o and Gabbylicious's tricks taken: " + team2tricks);
        twototalbags.setText("mAne11o and Gabbylicious's total bags: " + team2bags);
        twoscore.setText("mAne11o and Gabbylicious's points this round: " + team2score);
        
       
        
    }
   
    
    private int pointscheck(int point, int bid, int bags){
        int total;
        
        if((point - bid) < 0){
            total = (-10 * bid);
        }
        
        else{
            total = ((bid * 10) + bags);
        }
        
        return total;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructionsPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lobbyPanel = new javax.swing.JPanel();
        placingPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numPlayers = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lobbyBackground = new javax.swing.JLabel();
        finalPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        onescore = new javax.swing.JLabel();
        onetotalbid = new javax.swing.JLabel();
        onetotaltricks = new javax.swing.JLabel();
        onetotalbags = new javax.swing.JLabel();
        twoscore = new javax.swing.JLabel();
        twototalbags = new javax.swing.JLabel();
        twototaltricks = new javax.swing.JLabel();
        twototalbid = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();
        dialogPanel = new javax.swing.JPanel();
        dialogBox = new javax.swing.JScrollPane();
        dialogText = new javax.swing.JTextArea();
        bidPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        bidField = new javax.swing.JTextField();
        bidSubmit = new javax.swing.JButton();
        youBidLabel = new javax.swing.JLabel();
        mannyBidLabel = new javax.swing.JLabel();
        gabbyBidLabel = new javax.swing.JLabel();
        barbBidLabel = new javax.swing.JLabel();
        yourCard = new javax.swing.JLabel();
        barbaraCard = new javax.swing.JLabel();
        mannyCard = new javax.swing.JLabel();
        gabbyCard = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        a7 = new javax.swing.JLabel();
        a8 = new javax.swing.JLabel();
        a9 = new javax.swing.JLabel();
        a10 = new javax.swing.JLabel();
        a11 = new javax.swing.JLabel();
        a12 = new javax.swing.JLabel();
        a13 = new javax.swing.JLabel();
        mannyCards = new javax.swing.JLabel();
        gabbyCards = new javax.swing.JLabel();
        barbaraCards = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        logUsername = new javax.swing.JTextField();
        logPassword = new javax.swing.JPasswordField();
        logButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loginBackground = new javax.swing.JLabel();
        playerOptionsPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        playNow = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        createAccountBackground = new javax.swing.JLabel();
        spadesIntro = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 700));
        setMinimumSize(new java.awt.Dimension(960, 700));
        setPreferredSize(new java.awt.Dimension(960, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        instructionsPanel.setMaximumSize(new java.awt.Dimension(955, 662));
        instructionsPanel.setMinimumSize(new java.awt.Dimension(955, 662));
        instructionsPanel.setPreferredSize(new java.awt.Dimension(955, 662));
        instructionsPanel.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel12.setText("Instructions");
        instructionsPanel.add(jLabel12);
        jLabel12.setBounds(400, 0, 160, 50);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Britannic Bold", 0, 20)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("1. The cards, in each suit, rank from highest to lowest: A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2.\n\n2. The entire deck is dealt giving each of four players 13 cards.\n\n3. Following the deal, each player bids by declaring the number of tricks they believe they can take (the number of rounds they believe they can win).\n\n4. There are two teams. Each team consists of two players who sit across from each other.\n\n5. Though players bid individually, a partnershipâ€™s bids are combined for scoring. \n\n6. A player may bid Nil if he or she believes they can take zero tricks. Achieving a Nil bid results in a score of 100 points but failing Nil subtracts 100 points from the teamâ€™s score.\n\n7. Spades may not be led until theyâ€™ve been played on a previous hand, unless the player has only Spades. \n\n8. Play continues clockwise following the led suit, if possible, or playing any other card if not.\n\n9. When all four players have played, the trick is taken by the player who played the highest Spade, if any, or the player who played the highest card of the led suit otherwise.\n\n10. The player who takes the trick leads the next trick.\n\n11. If a team makes or exceeds their combined bid, they are awarded 10 points per bid plus 1 point per extra tricks taken (extra tricks are called bags). \n\n12. If a team fails to achieve their bid, their score is not changed.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        instructionsPanel.add(jScrollPane1);
        jScrollPane1.setBounds(0, 40, 950, 570);

        jButton5.setBackground(new java.awt.Color(75, 220, 143));
        jButton5.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jButton5.setText("GO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        instructionsPanel.add(jButton5);
        jButton5.setBounds(420, 620, 110, 40);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/overallbackground.jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        instructionsPanel.add(jLabel15);
        jLabel15.setBounds(0, 0, 955, 662);

        getContentPane().add(instructionsPanel);
        instructionsPanel.setBounds(0, 0, 955, 662);

        lobbyPanel.setMaximumSize(new java.awt.Dimension(955, 662));
        lobbyPanel.setMinimumSize(new java.awt.Dimension(955, 662));
        lobbyPanel.setLayout(null);

        placingPanel.setBackground(new java.awt.Color(153, 192, 185));

        jLabel9.setBackground(new java.awt.Color(153, 192, 185));
        jLabel9.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Placing Players in Game");

        javax.swing.GroupLayout placingPanelLayout = new javax.swing.GroupLayout(placingPanel);
        placingPanel.setLayout(placingPanelLayout);
        placingPanelLayout.setHorizontalGroup(
            placingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        placingPanelLayout.setVerticalGroup(
            placingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        lobbyPanel.add(placingPanel);
        placingPanel.setBounds(210, 250, 510, 110);

        jLabel2.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel2.setText("Lobby");
        lobbyPanel.add(jLabel2);
        jLabel2.setBounds(440, 10, 80, 60);

        numPlayers.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        numPlayers.setText("Number of users waiting to play: 3");
        lobbyPanel.add(numPlayers);
        numPlayers.setBounds(240, 80, 490, 40);

        jLabel14.setBackground(new java.awt.Color(153, 192, 185));
        jLabel14.setOpaque(true);
        lobbyPanel.add(jLabel14);
        jLabel14.setBounds(30, 10, 890, 130);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/spade.gif"))); // NOI18N
        lobbyPanel.add(jLabel19);
        jLabel19.setBounds(0, 0, 955, 662);

        lobbyBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/overallbackground.jpg"))); // NOI18N
        lobbyPanel.add(lobbyBackground);
        lobbyBackground.setBounds(0, 0, 955, 662);

        getContentPane().add(lobbyPanel);
        lobbyPanel.setBounds(0, 0, 955, 662);

        finalPanel.setMaximumSize(new java.awt.Dimension(955, 662));
        finalPanel.setMinimumSize(new java.awt.Dimension(955, 662));
        finalPanel.setRequestFocusEnabled(false);
        finalPanel.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Score");
        finalPanel.add(jLabel8);
        jLabel8.setBounds(390, 0, 190, 50);

        onescore.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        onescore.setText("USERNAME and justiceforbarb2017's points this round:");
        finalPanel.add(onescore);
        onescore.setBounds(20, 250, 910, 60);

        onetotalbid.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        onetotalbid.setText("USERNAME and justiceforbarb2017's total bid:");
        finalPanel.add(onetotalbid);
        onetotalbid.setBounds(20, 80, 910, 60);

        onetotaltricks.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        onetotaltricks.setText("USERNAME and justiceforbarb2017's tricks taken:");
        finalPanel.add(onetotaltricks);
        onetotaltricks.setBounds(20, 140, 910, 60);

        onetotalbags.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        onetotalbags.setText("USERNAME and justiceforbarb2017's total bags:");
        finalPanel.add(onetotalbags);
        onetotalbags.setBounds(20, 190, 910, 60);

        twoscore.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        twoscore.setText("mAne11o and Gabbylicious's points this round:");
        finalPanel.add(twoscore);
        twoscore.setBounds(20, 510, 910, 60);

        twototalbags.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        twototalbags.setText("mAne11o and Gabbylicious's total bags:");
        finalPanel.add(twototalbags);
        twototalbags.setBounds(20, 450, 910, 60);

        twototaltricks.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        twototaltricks.setText("mAne11o and Gabbylicious's tricks taken:");
        finalPanel.add(twototaltricks);
        twototaltricks.setBounds(20, 400, 910, 60);

        twototalbid.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        twototalbid.setText("mAne11o and Gabbylicious's total bid:");
        finalPanel.add(twototalbid);
        twototalbid.setBounds(20, 340, 910, 60);

        jButton2.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        finalPanel.add(jButton2);
        jButton2.setBounds(440, 590, 69, 40);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/darkening.png"))); // NOI18N
        finalPanel.add(jLabel18);
        jLabel18.setBounds(10, 10, 930, 640);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/overallbackground.jpg"))); // NOI18N
        finalPanel.add(jLabel17);
        jLabel17.setBounds(0, 0, 955, 662);

        getContentPane().add(finalPanel);
        finalPanel.setBounds(0, 0, 955, 662);

        gamePanel.setBackground(new java.awt.Color(0, 153, 51));
        gamePanel.setMaximumSize(new java.awt.Dimension(955, 662));
        gamePanel.setMinimumSize(new java.awt.Dimension(955, 662));
        gamePanel.setLayout(null);

        dialogPanel.setBackground(new java.awt.Color(153, 192, 185));

        dialogBox.setBackground(new java.awt.Color(153, 192, 185));

        dialogText.setEditable(false);
        dialogText.setColumns(20);
        dialogText.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        dialogText.setLineWrap(true);
        dialogText.setRows(5);
        dialogText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dialogTextMouseClicked(evt);
            }
        });
        dialogBox.setViewportView(dialogText);

        javax.swing.GroupLayout dialogPanelLayout = new javax.swing.GroupLayout(dialogPanel);
        dialogPanel.setLayout(dialogPanelLayout);
        dialogPanelLayout.setHorizontalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogBox, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogPanelLayout.setVerticalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogBox, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        gamePanel.add(dialogPanel);
        dialogPanel.setBounds(10, 450, 940, 150);

        bidPanel.setBackground(new java.awt.Color(153, 192, 185));
        bidPanel.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel10.setText("Enter a bid between 0 and 13:");
        bidPanel.add(jLabel10);
        jLabel10.setBounds(216, 13, 388, 28);

        bidField.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        bidField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bidPanel.add(bidField);
        bidField.setBounds(351, 48, 113, 30);

        bidSubmit.setText("GO");
        bidSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bidSubmitActionPerformed(evt);
            }
        });
        bidPanel.add(bidSubmit);
        bidSubmit.setBounds(369, 85, 70, 45);

        gamePanel.add(bidPanel);
        bidPanel.setBounds(60, 240, 820, 130);

        youBidLabel.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        youBidLabel.setText("USERNAME bids 11");
        gamePanel.add(youBidLabel);
        youBidLabel.setBounds(360, 600, 220, 30);

        mannyBidLabel.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        mannyBidLabel.setText("mAne11o bids 11");
        gamePanel.add(mannyBidLabel);
        mannyBidLabel.setBounds(0, 80, 220, 30);

        gabbyBidLabel.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        gabbyBidLabel.setText("Gabbylicious bids 11");
        gamePanel.add(gabbyBidLabel);
        gabbyBidLabel.setBounds(730, 80, 220, 30);

        barbBidLabel.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        barbBidLabel.setText("justiceforbarb2017 bids 2");
        gamePanel.add(barbBidLabel);
        barbBidLabel.setBounds(340, 10, 290, 30);
        gamePanel.add(yourCard);
        yourCard.setBounds(450, 330, 70, 100);
        gamePanel.add(barbaraCard);
        barbaraCard.setBounds(450, 150, 70, 100);
        gamePanel.add(mannyCard);
        mannyCard.setBounds(350, 240, 70, 100);
        gamePanel.add(gabbyCard);
        gabbyCard.setBounds(550, 240, 70, 100);

        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a1.setToolTipText("");
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1MouseClicked(evt);
            }
        });
        gamePanel.add(a1);
        a1.setBounds(20, 450, 70, 100);

        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
        });
        gamePanel.add(a2);
        a2.setBounds(860, 450, 70, 100);

        a3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
        });
        gamePanel.add(a3);
        a3.setBounds(90, 450, 70, 100);

        a4.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4MouseClicked(evt);
            }
        });
        gamePanel.add(a4);
        a4.setBounds(160, 450, 70, 100);

        a5.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a5MouseClicked(evt);
            }
        });
        gamePanel.add(a5);
        a5.setBounds(230, 450, 70, 100);

        a6.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a6MouseClicked(evt);
            }
        });
        gamePanel.add(a6);
        a6.setBounds(300, 450, 70, 100);

        a7.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a7MouseClicked(evt);
            }
        });
        gamePanel.add(a7);
        a7.setBounds(370, 450, 70, 100);

        a8.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a8MouseClicked(evt);
            }
        });
        gamePanel.add(a8);
        a8.setBounds(440, 450, 70, 100);

        a9.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a9MouseClicked(evt);
            }
        });
        gamePanel.add(a9);
        a9.setBounds(510, 450, 70, 100);

        a10.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a10MouseClicked(evt);
            }
        });
        gamePanel.add(a10);
        a10.setBounds(580, 450, 70, 100);

        a11.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a11MouseClicked(evt);
            }
        });
        gamePanel.add(a11);
        a11.setBounds(650, 450, 70, 100);

        a12.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a12MouseClicked(evt);
            }
        });
        gamePanel.add(a12);
        a12.setBounds(720, 450, 70, 100);

        a13.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/h10.png"))); // NOI18N
        a13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a13MouseClicked(evt);
            }
        });
        gamePanel.add(a13);
        a13.setBounds(790, 450, 70, 100);
        gamePanel.add(mannyCards);
        mannyCards.setBounds(10, 110, 100, 330);
        gamePanel.add(gabbyCards);
        gabbyCards.setBounds(810, 110, 100, 330);
        gamePanel.add(barbaraCards);
        barbaraCards.setBounds(300, 40, 330, 100);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/overallbackground.jpg"))); // NOI18N
        gamePanel.add(jLabel16);
        jLabel16.setBounds(0, 0, 955, 662);

        getContentPane().add(gamePanel);
        gamePanel.setBounds(0, 0, 955, 662);

        loginPanel.setMaximumSize(new java.awt.Dimension(955, 662));
        loginPanel.setMinimumSize(new java.awt.Dimension(955, 662));
        loginPanel.setPreferredSize(new java.awt.Dimension(955, 662));
        loginPanel.setLayout(null);

        logUsername.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        loginPanel.add(logUsername);
        logUsername.setBounds(440, 130, 290, 40);
        loginPanel.add(logPassword);
        logPassword.setBounds(440, 190, 290, 40);

        logButton.setBackground(new java.awt.Color(75, 220, 143));
        logButton.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        logButton.setText("GO");
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });
        loginPanel.add(logButton);
        logButton.setBounds(410, 260, 130, 50);

        jLabel7.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Create An Account");
        loginPanel.add(jLabel7);
        jLabel7.setBounds(490, 460, 250, 40);

        jLabel4.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Don't have an account?");
        loginPanel.add(jLabel4);
        jLabel4.setBounds(140, 440, 360, 80);

        jLabel5.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Username:");
        loginPanel.add(jLabel5);
        jLabel5.setBounds(210, 110, 260, 80);

        jLabel6.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Password:");
        loginPanel.add(jLabel6);
        jLabel6.setBounds(220, 170, 240, 80);

        jLabel3.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Log In");
        loginPanel.add(jLabel3);
        jLabel3.setBounds(340, 0, 280, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/darkening.png"))); // NOI18N
        loginPanel.add(jLabel1);
        jLabel1.setBounds(30, 20, 900, 310);

        loginBackground.setBackground(new java.awt.Color(0, 102, 51));
        loginBackground.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        loginBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/overallbackground.jpg"))); // NOI18N
        loginPanel.add(loginBackground);
        loginBackground.setBounds(0, 0, 955, 662);

        getContentPane().add(loginPanel);
        loginPanel.setBounds(0, 0, 955, 662);

        playerOptionsPanel.setMaximumSize(new java.awt.Dimension(955, 660));
        playerOptionsPanel.setMinimumSize(new java.awt.Dimension(955, 660));
        playerOptionsPanel.setLayout(null);

        jButton1.setBackground(new java.awt.Color(75, 220, 143));
        jButton1.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jButton1.setText("Score");
        playerOptionsPanel.add(jButton1);
        jButton1.setBounds(350, 440, 270, 50);

        playNow.setBackground(new java.awt.Color(75, 220, 143));
        playNow.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        playNow.setText("Play Now");
        playNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playNowActionPerformed(evt);
            }
        });
        playerOptionsPanel.add(playNow);
        playNow.setBounds(350, 180, 270, 50);

        jButton3.setBackground(new java.awt.Color(75, 220, 143));
        jButton3.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jButton3.setText("Game History");
        playerOptionsPanel.add(jButton3);
        jButton3.setBounds(350, 260, 270, 50);

        jButton4.setBackground(new java.awt.Color(75, 220, 143));
        jButton4.setFont(new java.awt.Font("Broadway", 0, 24)); // NOI18N
        jButton4.setText("Friends Online");
        playerOptionsPanel.add(jButton4);
        jButton4.setBounds(350, 350, 270, 50);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/darkening.png"))); // NOI18N
        playerOptionsPanel.add(jLabel13);
        jLabel13.setBounds(310, 130, 340, 410);

        createAccountBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/overallbackground.jpg"))); // NOI18N
        createAccountBackground.setMaximumSize(new java.awt.Dimension(955, 662));
        createAccountBackground.setMinimumSize(new java.awt.Dimension(955, 662));
        createAccountBackground.setPreferredSize(new java.awt.Dimension(955, 662));
        playerOptionsPanel.add(createAccountBackground);
        createAccountBackground.setBounds(1, -1, 955, 662);

        getContentPane().add(playerOptionsPanel);
        playerOptionsPanel.setBounds(0, 0, 955, 660);

        spadesIntro.setBackground(new java.awt.Color(0, 0, 0));
        spadesIntro.setMaximumSize(new java.awt.Dimension(955, 662));
        spadesIntro.setLayout(null);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/spades.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        spadesIntro.add(jLabel11);
        jLabel11.setBounds(220, 70, 500, 492);

        getContentPane().add(spadesIntro);
        spadesIntro.setBounds(0, 0, 955, 662);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playNowActionPerformed
        playerOptionsPanel.setVisible(false);
        lobbyPanel.setVisible(true);
        timer.setRepeats(true);
        timer.start();    
    }//GEN-LAST:event_playNowActionPerformed

    private void bidSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bidSubmitActionPerformed
        timer.stop();
        yourbid = Integer.parseInt(bidField.getText());
        if((yourbid != (int)yourbid)||(yourbid > 13)||(yourbid < 0)){
            JOptionPane.showMessageDialog(null,"Incorrect input. Please enter a valid number.");
        }
        
        else{
            bidPanel.setVisible(false);
            youBidLabel.setText(playername + " bids " + yourbid);
            turn = random.nextInt(3) + 0;
            startingturn = turn;
            
            round();
        }
    }//GEN-LAST:event_bidSubmitActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        spadesIntro.setVisible(false);
        loginPanel.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
       
        playername = logUsername.getText();
        
        if(playername.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter a valid username.");
        }
        
        else{
            loginPanel.setVisible(false);
            playerOptionsPanel.setVisible(true);
        }
    }//GEN-LAST:event_logButtonActionPerformed

    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
        
        playerOne(0,0);
        if(submitted == 1){
            p1 = 1;
            a1.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a1MouseClicked

    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked
        playerOne(1,0);
        if(submitted == 1){
            p1 = 1;
            a3.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a3MouseClicked

    private void a4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseClicked
        playerOne(2,0);
        if(submitted == 1){
            p1 = 1;
            a4.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a4MouseClicked

    private void a5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseClicked
       playerOne(3,0);
        if(submitted == 1){
            p1 = 1;
            a5.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a5MouseClicked

    private void a6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseClicked
        playerOne(4,0);
        if(submitted == 1){
            p1 = 1;
            a6.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a6MouseClicked

    private void a7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseClicked
       playerOne(5,0);
        if(submitted == 1){
            p1 = 1;
            a7.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a7MouseClicked

    private void a8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a8MouseClicked
        playerOne(6,0);
        if(submitted == 1){
            p1 = 1;
            a8.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a8MouseClicked

    private void a9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a9MouseClicked
        playerOne(7,0);
        if(submitted == 1){
            p1 = 1;
            a9.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a9MouseClicked

    private void a10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a10MouseClicked
        playerOne(8,0);
        if(submitted == 1){
            p1 = 1;
            a10.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a10MouseClicked

    private void a11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a11MouseClicked
        playerOne(9,0);
        if(submitted == 1){
            p1 = 1;
            a11.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a11MouseClicked

    private void a12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a12MouseClicked
        playerOne(10,0);
        if(submitted == 1){
            p1 = 1;
            a12.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a12MouseClicked

    private void a13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a13MouseClicked
        playerOne(11,0);
        if(submitted == 1){
            p1 = 1;
            a13.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a13MouseClicked

    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked
        playerOne(12,0);
        if(submitted == 1){
            p1 = 1;
            a2.setIcon(null);
            youBidLabel.setForeground(Color.BLACK);
            round();
        }
    }//GEN-LAST:event_a2MouseClicked

    private void dialogTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dialogTextMouseClicked
        dialogPanel.setVisible(false);
        yes = 1;
        
        if((p1 == 1) && (p2 == 1) && (p3 == 1) && (p4 == 1)){
            timer7.stop();
            p1 = 0;
            p2 = 0;
            p3 = 0;
            p4 = 0;
            gabbyCard.setIcon(null);
            yourCard.setIcon(null);
            mannyCard.setIcon(null);
            barbaraCard.setIcon(null);
            lo = 0;
            round();
        }
    }//GEN-LAST:event_dialogTextMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        instructionsPanel.setVisible(false);
        gamePanel.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(spades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(spades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(spades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(spades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new spades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a10;
    private javax.swing.JLabel a11;
    private javax.swing.JLabel a12;
    private javax.swing.JLabel a13;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    private javax.swing.JLabel barbBidLabel;
    private javax.swing.JLabel barbaraCard;
    private javax.swing.JLabel barbaraCards;
    private javax.swing.JTextField bidField;
    private javax.swing.JPanel bidPanel;
    private javax.swing.JButton bidSubmit;
    private javax.swing.JLabel createAccountBackground;
    private javax.swing.JScrollPane dialogBox;
    private javax.swing.JPanel dialogPanel;
    private javax.swing.JTextArea dialogText;
    private javax.swing.JPanel finalPanel;
    private javax.swing.JLabel gabbyBidLabel;
    private javax.swing.JLabel gabbyCard;
    private javax.swing.JLabel gabbyCards;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel instructionsPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lobbyBackground;
    private javax.swing.JPanel lobbyPanel;
    private javax.swing.JButton logButton;
    private javax.swing.JPasswordField logPassword;
    private javax.swing.JTextField logUsername;
    private javax.swing.JLabel loginBackground;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel mannyBidLabel;
    private javax.swing.JLabel mannyCard;
    private javax.swing.JLabel mannyCards;
    private javax.swing.JLabel numPlayers;
    private javax.swing.JLabel onescore;
    private javax.swing.JLabel onetotalbags;
    private javax.swing.JLabel onetotalbid;
    private javax.swing.JLabel onetotaltricks;
    private javax.swing.JPanel placingPanel;
    private javax.swing.JButton playNow;
    private javax.swing.JPanel playerOptionsPanel;
    private javax.swing.JPanel spadesIntro;
    private javax.swing.JLabel twoscore;
    private javax.swing.JLabel twototalbags;
    private javax.swing.JLabel twototalbid;
    private javax.swing.JLabel twototaltricks;
    private javax.swing.JLabel youBidLabel;
    private javax.swing.JLabel yourCard;
    // End of variables declaration//GEN-END:variables
}