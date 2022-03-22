;********************************************************************
;* Demonstration Program                                            *
;*                                                                  *
;* This program illustrates how to use the assembler.               *
;* It adds together two 8 bit numbers and leaves the result         *
;* in the ‘SUM’ location.                                           *
;* Author: Peter Hiscocks                                           *
;********************************************************************
; export symbols
            XDEF Entry, _Startup ; export ‘Entry’ symbol
            ABSENTRY Entry ; for absolute assembly: mark
; this as applicat. entry point
; Include derivative-specific definitions
    INCLUDE 'derivative.inc'
;********************************************************************
;* Code section                                                     *
;********************************************************************
            ORG $3000
MULTIPLICAND FCB 05 ; First Number
MULTIPLIER FCB 02 ; Second Number
PRODUCT RMB 2 ; Result of multiplication
;********************************************************************
;* The actual program starts here                                   *
;********************************************************************
            ORG $4000
Entry:
_Startup:
            LDAA MULTIPLICAND ; Get the first number into LDAA
            LDAB MULTIPLIER ; Get the first number into LDAB
            MUL ; Multiply the Multiplicand by the Multiplier
            STD PRODUCT ; Store the result of MUL in the 16 bit PRODUCT
            SWI ; break to the monitor
;********************************************************************
;* Interrupt Vectors                                                *
;********************************************************************
            ORG $FFFE
            FDB Entry ; Reset Vector