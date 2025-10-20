import requests
from colorama import init, Fore
init(autoreset=True)

headers = {'Accept': 'application/json'}

r = requests.get('http://localhost:8080/conserto', headers=headers)
lista = r.json()

for d in lista:
    print(Fore.CYAN + "ID:", Fore.YELLOW + str(d.get('id', 'N/A')))
    print(Fore.CYAN + "Data Início:", Fore.YELLOW + d.get('dt_inicio', 'N/A'))
    print(Fore.CYAN + "Data Fim:", Fore.YELLOW + d.get('dt_fim', 'N/A'))
    
    mecanico = d.get('mecanico', {})
    print(Fore.MAGENTA + "Mecânico:", Fore.GREEN + mecanico.get('nome', 'N/A'), 
          Fore.MAGENTA + "Anos de Experiência:", Fore.YELLOW + str(mecanico.get('anosExp', 'N/A')))
    
    veiculo = d.get('veiculo', {})
    print(veiculo)
    print(Fore.BLUE + "Modelo:", Fore.GREEN + veiculo.get('modelo', 'N/A'), "-", 
          "Marca:", Fore.GREEN + veiculo.get('marca', 'N/A'))
    print(Fore.BLUE + "Ano:", Fore.YELLOW + veiculo.get('ano_carro', 'N/A'), "-",
          "Cor:", Fore.GREEN + veiculo.get('cor', 'N/A'))
   
    
    print(Fore.WHITE + "-"*40) 
