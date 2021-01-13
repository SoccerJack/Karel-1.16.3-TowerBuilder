public class TowerBuilderKarel extends SuperKarel
{
    public void run()
    {
        /*continuosuly checks if the front is 
        clear before building a new tower*/
        while(frontIsClear())
        {
            buildTower();
            move();
            if(frontIsClear())
            {
                move();
            }
        }

        /* if the front is blocked, make Karel check
        for where the next tower has to be placed */
        if(frontIsBlocked())
        {
            /* tests for if Karel is in a 1 column area */
            turnAround();
            if(frontIsBlocked())
            {
                turnAround();
                buildTower();
            }
            /* the else statement lets Karel know where
            he has to end up in the end of the level */
            else
            {
                /* tests for if Karel has a tower
                behind him, and if he does, make a tower
                that is 1 more space away from the previous */
                move();
                if(ballsPresent())
                {
                    turnAround();
                    move();
                }
                /* if there is not a tower, go to the corner of 
                the level so that it is completed */
                else
                {
                    move();
                    if(ballsPresent())
                    {
                        turnAround();
                        move();
                        /* only build a tower if there are no spaces
                        behind you and if there is no space in front*/
                        if(frontIsClear())
                        {
                            move();
                            buildTower();
                        }
                    }
                }
            }
            
        }
        
    }
    
    /* build a tower and go back to the bottom */
    private void buildTower()
    {
        turnLeft();
        putBall();
        move();
        putBall();
        move();
        putBall();
        turnAround();
        move();
        move();
        turnLeft();
    }
}
