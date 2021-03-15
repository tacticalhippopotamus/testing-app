package com.testing.logic;

/**
 * Class containing main logic for the game.
 * <p>
 * when updated through {@link BaseObject#objectUpdate()}} the game is played.
 * {@link Sequence} and {@link GameLogic#colors} are updated in {@link com.testing.screens.MainGameScreen}
 */
public class GameLogic {//extends BaseObject*/ implements OTIDrawable {
//
//    /**
//     * Array of buttons used to play the game.
//     */
//    private final ColorButton[] colors;
//
//    /**
//     * {@link Sequence} object holding necessary data and some of the functionality
//     */
//    private final Sequence sequence;
//
//    /**
//     * How long the sequence of button presses is, not how big the grid it
//     */
//    private final int sequenceLength;
//    /**
//     * how many frames between each blink in {@link GameState#PROMPT} stage
//     */
//    private final int delayFrames;
//
//    private boolean success;
//    /**
//     * How many frames has it been since the last blink
//     */
//    private int delayCount = 0;
//    /**
//     * which iteration of the sequence is being played (not the current level)
//     */
//    private int round;
//
//    /**
//     * Constructor. Positions the buttons in a grid. Initializes the {@link Sequence}.
//     *
//     * @param sequenceLength length of the sequence
//     * @param gridSize       length of one side of the grid (grid contains gridSize^2 buttons)
//     * @param delayFrames    how many frames between prompts
//     */
//    public GameLogic(int sequenceLength, int gridSize, int delayFrames) {
//        this.sequenceLength = sequenceLength;
//        this.delayFrames = delayFrames;
//
//        success = true;
//        round = 0;
//
//        //TODO: better way to position buttons
//        int screenWidth = Gdx.graphics.getWidth();
//        int screenHeight = Gdx.graphics.getHeight();
//        int gridOffsetX = screenWidth / 5;
//        int buttonWithGap = (gridOffsetX * 3) / gridSize;
//        int gridOffsetY = (screenHeight - (buttonWithGap * gridSize)) / 2;
//        int gap = buttonWithGap / 10;
//        colors = new ColorButton[gridSize * gridSize];
//        sequence = new Sequence(sequenceLength, gridSize);
//
//        for (int i = 0; i < gridSize; i++) {
//            for (int j = 0; j < gridSize; j++) {
//                // TODO: better colors
//                colors[i * gridSize + j] = new ColorButton(gridOffsetX, gridOffsetY, buttonWithGap - gap, buttonWithGap - gap,
//                        new Color((float) i / gridSize, 0.7f, (float) j / gridSize, 1f));
//                gridOffsetX += buttonWithGap;
//            }
//            gridOffsetY += buttonWithGap;
//            gridOffsetX = screenWidth / 5;
//        }
//
//    }
//
//    /**
//     * calling the full constructor and defaulting delay between blinks to 30 frames
//     *
//     * @param sequenceLength length of the sequence
//     * @param gridSize       how long the side of the grid it
//     */
//    public GameLogic(int sequenceLength, int gridSize) {
//        this(sequenceLength, gridSize, 30);
//    }
//
//    /**
//     * Take different action depending what state the game is in.
//     * <p>
//     * PROMPT:
//     * phase of the game when the sequence is played
//     * squares are blinked in sequence (using {@link ColorButton#blink(int frames)}
//     * ANSWER:
//     * the user repeats back the sequence
//     * they enter it by pressing the buttons
//     * buttons blink when pressed
//     * input is recorded and stored by the sequence object
//     * RESULT:
//     * this state can result from both success or failure
//     * in order to complete the level, the user has to succeed in all rounds
//     * {@link Sequence#isSuccess()} returns whether the user succeeded in the current round
//     * {@link GameLogic#success} holds information about success in all rounds
//     * from the result state, program goes to the next round and returns to IDLE
//     *
//     * @param roundLength how long is the currently shown sequence (not the total length of sequence)
//     */
//    private void actOnState(int roundLength) {
//        sequence.setLength(roundLength + 1);
//        switch (sequence.getState()) {
//            case IDLE:
//                break;
//            case PROMPT:
//                int yield;
//                if ((yield = sequence.yield()) >= 0) {
//                    colors[yield].blink(5);
//                }
//                break;
//            case ANSWER:
//                for (int i = 0; i < colors.length; i++) {
//                    if (colors[i].isReleased()) {
//                        colors[i].blink(5);
//                        sequence.input(i);
//                    }
//                }
//                break;
//            case RESULT:
//                success = sequence.isSuccess() && success;
//                round++;
//                sequence.setState(GameState.IDLE);
//                break;
//        }
//
//    }
//
//    /**
//     * introduces delay to the buttons blink for longer then a second
//     * when sufficient delay has been created, game moves to the next stage
//     */
//    private void delayCounter() {
//        if (sequence.getState() == GameState.IDLE || sequence.getState() == GameState.PROMPT) {
//            delayCount++;
//            if (delayCount < delayFrames) {
//                sequence.setState(GameState.IDLE);
//                return;
//            }
//
//            sequence.setState(GameState.PROMPT);
//            delayCount = 0;
//        }
//    }
//
//    /**
//     * checking whether the user has not failed and the rounds have not ended
//     */
//    //@Override
//    protected void objectUpdate() {
//        delayCounter();
//        if (success && round < sequenceLength) {
//            actOnState(round);
//        } else {
//            // TODO: do something with the value of success
//            System.out.println(success ? "success" : "no");
//        }
//    }
//
//
//    public List<ColorButton> getColors() {
//        return Arrays.asList(colors);
//    }
//
//    public Sequence getSequence() {
//        return sequence;
//    }
//
//    @Override
//    public void updateDrawable(SpriteBatch batch) {
//        for (ColorButton color : colors) {
//            color.update(batch); // FIXME: this is running all updates (including not ones related to OTIDrawable)
//        }
//    }
//
//    @Override
//    public void disposeDrawable() {
//        for (ColorButton color : colors) {
//            color.dispose();
//        }
//    }
}
