# Inicialização
clear
reset
set key off

# Configurações de saida: inclui formato de exportação, tamanho do gráfico, 
# fontes utilizadas e nome do arquivo de saída

# Exportação para o formato PNG
set terminal png size 640,480 enhanced font 'Helvetica,12'
set output 'histograma.png'

# Exportação para o formato JPG
# set terminal jpeg size 640,480 enhanced font 'Helvetica' 12
# set output 'histograma.jpg'

# Exportação para o formato SVG
# set terminal svg size 640,480 enhanced background rgb 'white' fname 'Helvetica' fsize 14 butt solid
# set output 'histograma.svg'

# Título do gráfico
set title 'Total de nascidos vivos no RN (1994-2020)'

# Configurações do eixo horizontal
set xrange[1994:2020]           # Faixa de valores
set xtics 1                     # Salto entre valores
set xtic rotate by -45 scale 0  # Rotação dos rótulos

# Configurações do eixo vertical
set yrange[0:80000]             # Faixa de valores

# Seleção do tipo de gráfico a ser gerado (histograma)
set style data histogram
set style histogram clustered gap 1
set style fill solid border -1      # Preenchimento e contorno
set linetype 1 lc rgb 'green'       # Cor
set boxwidth 0.6                    # Largura das barras verticais

# Plotagem do gráfico
# Os dados a serem plotados constam no arquivo totais.dat
plot 'totais.dat' using 1:2 title '' smooth freq with boxes