package ru.crystals.pos.fiscalprinter.atol3.highlevel.commands;

public class ModeReturnCommand extends CommandWithConfirmation {
    private static final int CODE = 0x48;

    public ModeReturnCommand() {
        super(CODE);
    }
}
