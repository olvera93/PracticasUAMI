load tcpplot2.dat
subplot(2, 3, 1)
plot(tcpplot2, '--r', 'LineWidth', 3)
grid on
xlabel('Vuelta de transmisión')
ylabel('cwnd [segmentos]')
title('Ventana de congestión de TCP')
print -dpng "Trazala.png"

subplot(2, 3, 2)
plot(tcpplot2, 'b-.p', 'LineWidth', 2.5)
grid on 
xlabel('Vuelta de transmisión')
ylabel('cwnd[segmentos]')
title('Ventana de congestión de TCP')

subplot(2, 3, 3)
plot(tcpplot2, 's', 'LineWidth', 1)
grid on
xlabel('Vuelta de transmisión')
ylabel('cwnd[segmentos]')
title('Ventana de congestión de TCP')