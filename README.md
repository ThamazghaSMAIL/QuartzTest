# QuartzTest

## Premiere solution : 
Quand un job s'arrête à cause d'une erreur ou autre, lancer un autre job avec les mêmes taches 
Je pense que ce n'est pas possible parce que : 
	- il est déconseillé de modifier directement les données en base. 
	- La librairie n’effectuant une analyse qu’au lancement de l’application, 
	elle ne tiendra alors pas compte des modification de la base et continuera
	à fonctionner avec les anciennes valeurs.
	
## Deuxième solution : 
Lancer plusieurs jobs qui se partagent les taches
Il suffit de rajouter les lignes suivantes dans le fichier des properties : 

**org.quartz.scheduler.instanceName: SchedulerName**
**org.quartz.scheduler.instanceId: InstanceName**

**org.quartz.jobStore.dontSetAutoCommitFalse: false**
**org.quartz.jobStore.acquireTriggersWithinLock: true**
**org.quartz.jobStore.isClustered: true**

Ça permet de spécifier un nom d’instance et un id d’instance à Quartz ainsi qu’un lock lors de l’exécution d’un trigger (pour éviter que deux instances essayent de lancer le même job)
Le nom de l’instance peut être différent sur chaque application exécutant Quartz mais il faut que l’id soit le même.

La répartition se produit que si la première instance Quartz est occupée. C’est alors la deuxième qui s’occupe du job suivant.


