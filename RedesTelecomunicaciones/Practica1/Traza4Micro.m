load data4.dat 
stem(data4(:,1), data4(:,2))
axis([0, 15, 0, 0.3])
xlabel('Tiempo de sesi�n[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 4.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Microsc�pica]")
print -dpng "Traza4Micro.png"