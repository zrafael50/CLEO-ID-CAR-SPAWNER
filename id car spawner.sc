SCRIPT_START
{
NOP

LVAR_INT veiculoid // VARIÁVEL DO VALOR QUE APARECE NA TELA

veiculoid = 400 // VALOR INICIAL DA VARIAVEL "veiculoid"

main_loop:
WAIT 0
IF IS_KEY_PRESSED VK_LMENU //O JOGADOR PRECISA PRIMEIRO APERTAR ALT ESQUERDO
    IF IS_KEY_PRESSED VK_KEY_B // ENQUANTO O JOGADOR SEGURA ALT ESQUERDO ELE PRECISA APERTAR B PRA ATIVAR O MOD
        loop2:
        WAIT 0
        PRINT_FORMATTED_NOW "~r~VEICULO:~w~ %i" 3000 veiculoid
        
        WAIT 1
        
        IF IS_KEY_PRESSED VK_UP // SE O JOGADOR APERTAR CIMA A VARIAVEL "veiculoid" AUMENTA
            veiculoid += 1
            WAIT 100
        ENDIF

        IF IS_KEY_PRESSED VK_DOWN // SE O JOGADOR APERTAR BAIXO A VARIAVEL "veiculoid" DIMINUI
            veiculoid -= 1
            WAIT 100
        ENDIF

        IF IS_KEY_PRESSED VK_LEFT // SE O JOGADOR APERTAR SETA ESQUERDA A VARIAVEL "veiculoid" DIMINUI 10 NÚMEROS
            veiculoid -= 10
            WAIT 100
        ENDIF

        IF IS_KEY_PRESSED VK_RIGHT // SE O JOGADOR APERTAR SETA DIREITA A VARIAVEL "veiculoid" AUMENTA 10 NÚMEROS
            veiculoid += 10
            WAIT 100
        ENDIF

        IF veiculoid < 400 // SE O JOGADOR COLOCAR UM NÚMERO MENOR QUE 400 A VARIÁVEL PASSA A SER 611
            WAIT 0
            veiculoid = 611
        ENDIF

        IF veiculoid > 611 // MESMA COISA DO IF ACIMA, SÓ QUE AO CONTRÁRIO
            WAIT 0
            veiculoid = 400
        ENDIF

        IF IS_KEY_PRESSED VK_LSHIFT // SE APERTAR SHIFT ESQUERDO SPAWNARÁ O VEÍCULO DESEJADO E VOLTARA PARA "loop2:"
            SPAWN_VEHICLE_BY_CHEATING veiculoid // VAI SPAWNAR UM VEICULO DE ACORDO COM O VALOR ESCOLHIDO PELO JOGADOR
            WAIT 100
            GOTO loop2
        ENDIF

        IF NOT IS_KEY_PRESSED VK_KEY_B // SE O JOGADOR NÃO APERTAR B, VOLTARÁ PARA "loop2", caso contrário, fechará o menu
            GOTO loop2
        ENDIF
    ENDIF
ENDIF

GOTO main_loop
}
SCRIPT_END