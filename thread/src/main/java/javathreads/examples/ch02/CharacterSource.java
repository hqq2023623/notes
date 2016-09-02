package javathreads.examples.ch02;

public interface CharacterSource {
    /**
     * 添加监听器
     *
     * @param cl
     */
    void addCharacterListener(CharacterListener cl);

    /**
     * 删除监听器
     *
     * @param cl
     */
    void removeCharacterListener(CharacterListener cl);

    /**
     * 下一个字母
     */
    void nextCharacter();
}    
