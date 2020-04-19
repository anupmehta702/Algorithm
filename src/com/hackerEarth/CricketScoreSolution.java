package com.hackerEarth;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


class Result {

    /*
     * Complete the 'findTopScorers' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER totalNoPlayers
     *  2. INTEGER totalMatches
     *  3. List<String> scores
     *  4. INTEGER n Minium no of matches for which a player should have been a top scorer
     */

    public static List<String> findTopScorers(int totalNoPlayers, int totalMatches, List<String> scores, int n) {
        System.out.println("scores-->" + scores);
        Map<Integer,List<PlayerScore>> matchTopScorersMap = new HashMap<>();
        for (String inputList : scores) {
            String[] input = inputList.split(",");
            int matchNo = 0;
            String playerName = "";
            for (String item : input) {
                if (!item.matches("^[0-9]*")) {
                    playerName = item;
                    matchNo = 0;
                } else {
                    Integer score = Integer.parseInt(item);
                    PlayerScore ps = new PlayerScore(playerName, score, matchNo);
                    if(matchTopScorersMap.containsKey(matchNo)){
                        if( matchTopScorersMap.get(matchNo).get(0).score < ps.score ) {
                            List<PlayerScore> psList = new ArrayList<>();
                            psList.add(ps);
                            matchTopScorersMap.put(matchNo, psList);
                        }else if ( matchTopScorersMap.get(matchNo).get(0).score == ps.score ){
                            List<PlayerScore> psList =matchTopScorersMap.get(matchNo);
                            psList.add(ps);
                            matchTopScorersMap.put(matchNo, psList);
                        }
                    }else{
                        List<PlayerScore> psList = new ArrayList<>();
                        psList.add(ps);
                        matchTopScorersMap.put(matchNo, psList);
                    }

                    matchNo++;
                }
            }
        }


        matchTopScorersMap.entrySet().stream().forEach((entry)->{
            System.out.println("Match - "+entry.getKey()+" value -->"+entry.getValue());
        });

        Map<String, Integer> playerTopScoresMap = new HashMap<>();

        matchTopScorersMap.entrySet().stream().forEach(entry->{
            List<PlayerScore> psList = entry.getValue();
            for(PlayerScore ps : psList){
                if (!playerTopScoresMap.isEmpty() && playerTopScoresMap.containsKey(ps.name)) {
                    int count = playerTopScoresMap.get(ps.name);
                    playerTopScoresMap.put(ps.name, ++count);
                } else {
                    if (ps != null) {
                        playerTopScoresMap.put(ps.name, 1);
                    }
                }
            }
        });


        List<String> playersWithNTopScore = playerTopScoresMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= n)
                .map(entry -> entry.getKey())
                .sorted()
                .collect(Collectors.toList());

        /*for(String player : playersWithNTopScore){
            System.out.println("Player - "+player);
        }*/
        return playersWithNTopScore;
    }

}

class PlayerScore {
    int score = 0;
    String name;
    int match;

    public PlayerScore(String name, int score, int match) {
        this.score = score;
        this.name = name;
        this.match = match;
    }

    @Override
    public String toString() {
        return "PlayerScore{" +
                "score=" + score +
                ", name='" + name + '\'' +
                ", match=" + match +
                '}';
    }
}

public class CricketScoreSolution {
    public static void main(String[] args) throws IOException {

/*
        List<String> scores =
                Arrays.asList(
                        "Sachin,10,10,10,10,10",
                        "Rahul,11,11,11,11,11",
                        "Dhoni,12,12,112,150,150",
                        "Ganguly,13,13,13,13,13",
                        "Raina,14,14,14,14,14",
                        "Virat,15,15,15,15,15",
                        "Yuvraj,16,16,16,16,16",
                        "Kumble,17,17,17,17,17",
                        "Sehwag,18,18,18,18,18",
                        "VVS,20,20,19,19,19",
                        "Bumrah,20,20,20,20,20");
*/
        List<String> scores =
                Arrays.asList("Sachin,100,100,23"
                       , "Rahul,10,20,40,5"
                        , "Dhoni,20,12,1,1");
        // System.out.println("output-->"+findTopScorers(3, 4, scores, 2));

        List<String> result = Result.findTopScorers(3, 5, scores, 2);
        System.out.println("result -->" + result);
    }
}
