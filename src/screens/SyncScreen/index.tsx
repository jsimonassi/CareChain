import {FlatList, Text} from 'react-native';
import {
  Container,
  ContainerSync,
  ContainerTop,
  DeviceContainer,
  DeviceTextDescription,
  MoneyImg,
  SmartwatchImg,
  SmartwatchImgContainer,
  SubDeviceContainer,
  SyncButton,
  TextDevice,
} from './styles';
import {TopBarComponent} from '../../components/TopBar';
import {Assets} from '../../assets/images';
import {GraphContainer} from './components/GraphContainer';

export const SyncScreen = () => {
  const DATA = [
    {
      id: 'bd7acbea-c1b1-46c2-aed5-3ad53abb28ba',
      title: 'Heart Rate',
      graphText: 'Gráfico de batimentos aqui. Visitar Victory Chart',
      description: 'TESTE',
      tokens: '100',
    },
    {
      id: '3ac68afc-c605-48d3-a4f8-fbd91aa97f63',
      title: 'Sleep',
      graphText: 'Gráfico de sono aqui. Visitar Victory Chart',
      description: ' TESTE',
      tokens: '100',
    },
  ];
  return (
    <Container>
      <TopBarComponent />

      <ContainerSync>
        <ContainerTop>
          <DeviceContainer>
            <SmartwatchImgContainer>
              <SmartwatchImg source={Assets.smartwatch} />
            </SmartwatchImgContainer>
            <SubDeviceContainer>
              <TextDevice>Life Ultra GPS</TextDevice>
              <DeviceTextDescription>AB:AB:00:4T:55:CC</DeviceTextDescription>
            </SubDeviceContainer>
          </DeviceContainer>
          <SyncButton>
            <MoneyImg source={Assets.money} />
          </SyncButton>
        </ContainerTop>
        <FlatList
          data={DATA}
          renderItem={({item}) => (
            <GraphContainer
              description={item.description}
              title={item.title}
              graphText={item.graphText}
              tokens={item.tokens}
            />
          )}
          keyExtractor={item => item.id}
        />
      </ContainerSync>
    </Container>
  );
};
