import {
  Container,
  ContainerDeviceNotFound,
  DeviceImg,
  SubContainer,
  SubTitleText,
  SubTitleTextDeviceNotFound,
  TitleText,
} from './styles';
import {Device} from './components/Device';
import {AppButton} from '../../components/buttons/AppButton';
import {useState} from 'react';
import {Assets} from '../../assets/images';
import {FlatList} from 'react-native';

export const Scanning = () => {
  const [foundDevices, setFoundDevices] = useState(true);

  const DATA = [
    {
      id: 1,
      name: 'Life Ultra GPS',
      description: 'AB:AB:00:4T:55:CC',
    },
    {
      id: 2,
      name: 'GTX44',
      description: 'AB:AB:00:4T:55:CC',
    },
    {
      id: 3,
      name: 'IDW30',
      description: 'AB:AB:00:4T:55:CC',
    },
  ];
  return (
    <Container>
      {foundDevices ? (
        <SubContainer>
          <SubTitleText>Select your device:</SubTitleText>

          <FlatList
            data={DATA}
            renderItem={({item}) => (
              <Device description={item.description} name={item.description} />
            )}
            keyExtractor={item => item.id}
          />
        </SubContainer>
      ) : (
        <ContainerDeviceNotFound>
          <DeviceImg source={Assets.device} />
          <TitleText>No devices nearby!</TitleText>
          <SubTitleTextDeviceNotFound>
            You can try again
          </SubTitleTextDeviceNotFound>
        </ContainerDeviceNotFound>
      )}

      <AppButton
        label="Search again"
        backgroundColor="primaryColor"
        textColor="white"
      />
    </Container>
  );
};
