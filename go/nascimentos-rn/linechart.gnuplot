# Configurações do arquivo de saída
set term png
set output "linechart.png"

# Configurações do gráfico
set title "Quantidade de Nascimentos por Ano"
set xlabel "Ano (1994-2020)"
set ylabel "Quantidade de Nascimentos"
set grid

# Configurações das linhas
set style line 1 lc rgb "#0060ad" lt 1 lw 2 pt 7 ps 0.5
set style line 2 lc rgb "#dd181f" lt 1 lw 2 pt 5 ps 0.5

# Definir o intervalo de anos
set xrange [1994:2020]

# Leitura dos dados do arquivo
plot "nascimentos-alvos.dat" using 1:2 with lines title "Nascimentos"

# Ou, se os dados estiverem em colunas separadas:
# plot "nascimentos-alvos.dat" using 1:2 with lines title "Nascimentos" lc rgb "#0060ad" lw 2

# Outras opções de formatação do gráfico podem ser adicionadas conforme necessário
