package javathreads.examples.ch02;

/**
 * 字母输入事件
 */
public class CharacterEvent {

    public CharacterSource source;
    public int character;

    public CharacterEvent(CharacterSource cs, int c) {
        source = cs;
        character = c;
    }

}
